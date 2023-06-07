
package Data;

import Entidad.Proyecto;
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
public class ProyectoData {
    
    
        private Connection con = null;

    public ProyectoData() {
        con = ConeccionData.getConexion();
    }

    public void guardarProyecto(Proyecto proyecto) {

        String sql = "INSERT INTO proyecto (nombre, descripcion, fechaInicio,estado) VALUES ( ?, ?, ?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            ps.setDate(3, Date.valueOf(proyecto.getFechaInicio())); // pasar de localdate a date para sql
            ps.setInt(4, 1);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                proyecto.setIdProyecto(rs.getInt("idProyecto"));
                JOptionPane.showMessageDialog(null, "Proyecto cargado exitosamente.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proyecto" + ex.getMessage());
        }

    }
    
      public void borrarProyecto (int idProyecto){
        String sql = "DELETE FROM `proyecto` WHERE idProyecto = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProyecto);   //Para setear el id donde esta el signo ?
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, " Proyecto Borrado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El proyecto no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El proyecto tiene equipos trabajando");
        }
    }
      
    public Proyecto buscarProyectoPorId(int id){
        Proyecto p = null;
        String sql = "SELECT * FROM proyecto WHERE idProyecto = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p =new Proyecto();
                p.setIdProyecto(rs.getInt("IdProyecto"));
                p.setNombre(rs.getString("nombre"));
                p.setEstado(rs.getInt("estado"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());//pasar Datesql a local Date
               
            } else {
             JOptionPane.showMessageDialog(null, "No existe el Proyecto", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proyecto "+ex.getMessage());
        }
        return p;
    }
    
}
