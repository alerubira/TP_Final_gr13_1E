
package Data;

import Entidad.Comentarios;
import Entidad.EquipoMiembros;
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
public class ComentariosData {
    
      private Connection con = null;

    public ComentariosData() {
        con = ConeccionData.getConexion();
    }

    public void guardarComentarios(Comentarios comentarios) {

        String sql = "INSERT INTO comentarios (idTarea, comentario , fechaAvance ) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, comentarios.getTarea().getIdTarea());
            ps.setString(2, comentarios.getComentario());
            ps.setDate(3, Date.valueOf(comentarios.getFechaAvance())); // pasar de localdate a date para sql
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                comentarios.setIdComentario(rs.getInt("idComentario"));
                JOptionPane.showMessageDialog(null, "Comentario cargado exitosamente.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comentarios" + ex.getMessage());
        }

    }
    
    public void borrarComentario (int idComentario) {
        String sql = "DELETE FROM `comentarios` WHERE idComentario = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idComentario);   //Para setear el id donde esta el signo ?
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comentario Borrado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Comentario no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El comentario esta ligado a una tarea ");
        }
    }
    
    public Comentarios buscarComentariosPorId(int id){
        Comentarios c = null;
        String sql = "SELECT * FROM comentarios WHERE idComentario = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c =new Comentarios();
                c.setIdComentario(rs.getInt("idComentario"));
                c.setComentario(rs.getString("comentarios"));
                TareaData td = new TareaData();
                c.setTarea(td.busacarTareaId(rs.getInt("idTarea")));
                c.setFechaAvance(rs.getDate("fechaAvance").toLocalDate());//pasar Datesql a local Date
               
            } else {
             JOptionPane.showMessageDialog(null, "No existe el comentario", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comentario "+ex.getMessage());
        }
        return c;
    }
    
     public void actualizarComentario(Comentarios comentario) {

        String sql = "UPDATE comentarios SET comentario = ?, fechaAvance = ?  WHERE  idComentario = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, comentario.getComentario());
            ps.setDate(2, Date.valueOf(comentario.getFechaAvance()));
            ps.setInt(3, comentario.getIdComentario());
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comentario Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El comentario no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comentario "+ex.getMessage());
        }
        
    }
     
      public List<Comentarios> obtenerComentarioPorTarea(int idTarea){
        List<Comentarios> comentarios = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM comentarios WHERE idTarea = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTarea);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comentarios c1 = new Comentarios();
                TareaData ad = new TareaData();     
                c1.setComentario(rs.getString("comentario"));
                c1.setFechaAvance(rs.getDate("fechaAvance").toLocalDate());
                c1.setIdComentario(rs.getInt("idComentario"));
                c1.setTarea(ad.busacarTareaId(rs.getInt("idTarea")));
                comentarios.add(c1);
            }
            ps.close();
           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla comentarios "+ex.getMessage());
        }
        return comentarios;
        
    }
    
}
