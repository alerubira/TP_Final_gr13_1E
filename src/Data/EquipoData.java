package Data;

import Entidad.Equipo;
import Entidad.EquipoMiembros;
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
public class EquipoData {

    private Connection con = null;

    public EquipoData() {
        con = ConeccionData.getConexion();
    }

    public void guardarEquipo(Equipo equipo) {

        String sql = "INSERT INTO equipo (idProyecto, nombre , fechaCreacion , estado ) VALUES (?, ?, ?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, equipo.getProyecto().getIdProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setDate(3, Date.valueOf(equipo.getFechaCreacion())); // pasar de localdate a date para sql
            ps.setBoolean(4, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                equipo.setIdEquipo(rs.getInt("idEquipo"));
                JOptionPane.showMessageDialog(null, "Equipo cargado exitosamente.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }

    }

    public void borrarEquipo(int idEquipo) {
        String sql = "DELETE FROM `equipo` WHERE idEquipo = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);   //Para setear el id donde esta el signo ?
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Equipo Borrado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Equipo no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El Equipo esta ligado a un proyecto ");
        }
    }
    
    public Equipo buscarEquipoPorId(int id){
        Equipo eq = null;
        String sql = "SELECT * FROM equipo WHERE idEquipo = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                eq =new Equipo();
                eq.setIdEquipo(rs.getInt("IdEquipo"));
                eq.setNombre(rs.getString("nombre"));
                eq.setEstado(rs.getBoolean("estado"));
                eq.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());
                ProyectoData pd = new ProyectoData();
                eq.setProyecto(pd.buscarProyectoPorId(rs.getInt("idProyecto")));
               
            } else {
             JOptionPane.showMessageDialog(null, "No existe el equipo", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla equipo "+ex.getMessage());
        }
        return eq;
    }

    public void actualizarEquipo(Equipo equipo) {

        String sql = "UPDATE equipo SET idProyecto = ?, nombre = ? , estado = ?  WHERE  idequipo = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equipo.getProyecto().getIdProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setBoolean(3,equipo.getEstado());
            ps.setInt(4, equipo.getIdEquipo());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Equipo Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El equipo no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo "+ex.getMessage());
        }
        
    }
    
}
