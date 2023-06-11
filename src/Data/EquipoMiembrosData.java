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

    public Miembro buscarMiembro(int idEquipo) {
         
        Miembro miembro = null;
        String sql = "SELECT idMiembro, apellido, nombre, dni, estado FROM equipomiembros WHERE idEquipo = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,idEquipo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                miembro =new Miembro();
                miembro.setIdMiembro(rs.getInt("idMiembro"));
                miembro.setDni(rs.getInt("dni"));
                miembro.setApellido(rs.getString("apellido"));
                miembro.setNombre(rs.getString("nombre"));
                miembro.setEstado(rs.getBoolean("estado"));
               
            } else {
             JOptionPane.showMessageDialog(null, "No existe el miembro", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro "+ex.getMessage());
        }
        return miembro;
    }
    
    public void buscarMiembros(int idEquipo){
        
    }
    public void buscarTareas(int idEquipo){
        
    }
    public void buscarTarea(int idMiembro){
        
    }
//    public void buscarMiembroPorIdTarea(int idTarea){
//        
//    }
}
