
package Data;

import Entidad.Comentarios;
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
    
    
    
}
