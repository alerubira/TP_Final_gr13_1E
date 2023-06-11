package Data;

import Entidad.Equipo;
import Entidad.EquipoMiembros;
import Entidad.Miembro;
import Entidad.Tarea;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class EquipoMiembrosData {

    private Connection con = null;

    public EquipoMiembrosData() {
        con = ConeccionData.getConexion();
    }

    public void guardarEquipoMiembro(EquipoMiembros equipomiembros) {

        String sql = "INSERT INTO equipomiembros (idEquipo, idMiembro , fechaIncorporacion ) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, equipomiembros.getEquipo().getIdEquipo());
            ps.setInt(2, equipomiembros.getMiembro().getIdMiembro());
            ps.setDate(3, Date.valueOf(equipomiembros.getFechaIncorporacion())); // pasar de localdate a date para sql
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                equipomiembros.setIdEquipoMiembros(rs.getInt("idEquipoMiembros"));
                JOptionPane.showMessageDialog(null, "Equipo Miembro cargado exitosamente.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla EquipoMiembros" + ex.getMessage());
        }

    }

    public void borrarEquipoMiembro(int idEquipoMiembro) {
        String sql = "DELETE FROM `equipomiembros` WHERE idEquipoMiembros = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipoMiembro);   //Para setear el id donde esta el signo ?
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Equipo Miembro Borrado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Equipo Miembro no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El Miembro esta en un equipo ");
        }
    }

    public EquipoMiembros buscarEquipoMiembroPorId(int id) {
        EquipoMiembros em = null;
        String sql = "SELECT * FROM equipomiembros WHERE idEquipoMiembros = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                em = new EquipoMiembros();
                em.setIdEquipoMiembros(rs.getInt("IdEquipoMiembros"));
                em.setFechaIncorporacion(rs.getDate("fechaIncorporacion").toLocalDate());//pasar datesql a localdate
                EquipoData ed = new EquipoData();
                em.setEquipo(ed.buscarEquipoPorId(rs.getInt("idEquipo")));
                MiembroData md = new MiembroData();
                em.setMiembro(md.buscarMiembroPorId(rs.getInt("IdMiembro")));

            } else {
                JOptionPane.showMessageDialog(null, "No existen Miembros en el Equipo", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla EquipoMiembros " + ex.getMessage());
        }
        return em;

    }

    public List<Miembro> buscarMiembrosPorEquipo(int idEquipo) {

        List<Miembro> miembros = new ArrayList();
        String sql = "SELECT M.* FROM miembro M JOIN equipomiembros EM ON(M.idMiembro=EM.idMiembro) JOIN equipo E ON(EM.idEquipo=E.idEquipo) WHERE E.idEquipo = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               Miembro m = new Miembro();
               
               m.setIdMiembro(rs.getInt("idMiembro"));
               m.setNombre(rs.getString("nombre"));
               m.setApellido(rs.getString("apellido"));
               m.setDni(rs.getInt("dni"));
               m.setEstado(rs.getBoolean("estado"));
            
                miembros.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro " + ex.getMessage());
        }
        
        return miembros;
    }
    
    public List<Tarea> buscarTareasPorEquipo(int idEquipo){
        List<Tarea> tareas = new ArrayList();
        String sql = "SELECT T.* FROM tarea T JOIN equipomiembros EM ON(T.idEquipoMiembros=EM.idEquipoMiembros) JOIN equipo E ON(EM.idEquipo=E.idEquipo) WHERE E.idEquipo = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               Tarea t = new Tarea();
               
               t.setIdTarea(rs.getInt("idTarea"));
               t.setNombr(rs.getString("nombre"));
               t.setFechaCierre(rs.getDate("fechaCierre").toLocalDate());
               t.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());
               t.setEstado(rs.getInt("estado"));
               EquipoMiembrosData emd = new EquipoMiembrosData();
               t.setEquipoMiembros(emd.buscarEquipoMiembroPorId(rs.getInt("idEquipoMiembros")));
            
                tareas.add(t);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla equipoMiembro " + ex.getMessage());
        }
        
        return tareas;
    }
    public Tarea buscarTareaPorMiembro(int idMiembro){
        Tarea t = new Tarea();
        String sql = "SELECT T.* FROM tarea T JOIN equipomiembros EM ON(T.idEquipoMiembros=EM.idEquipoMiembros) JOIN miembro M ON(EM.idMiembro=M.idMiembro) WHERE M.idMiembro = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMiembro);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
               t.setIdTarea(rs.getInt("idTarea"));
               t.setNombr(rs.getString("nombre"));
               t.setFechaCierre(rs.getDate("fechaCierre").toLocalDate());
               t.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());
               t.setEstado(rs.getInt("estado"));
               EquipoMiembrosData emd = new EquipoMiembrosData();
               t.setEquipoMiembros(emd.buscarEquipoMiembroPorId(rs.getInt("idEquipoMiembros")));    
            }else{
                JOptionPane.showMessageDialog(null, "El miembro no tiene ninguna tarea", "Error!", JOptionPane.ERROR_MESSAGE);
                t = null;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla equipoMiembro " + ex.getMessage());
        }
        
        return t;
    }
//    public void buscarMiembroPorIdTarea(int idTarea){
//        
//    }
}
