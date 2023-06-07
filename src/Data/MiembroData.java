package Data;

import Entidad.Miembro;
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
public class MiembroData {

    private Connection con = null;

    public MiembroData() {
        con = ConeccionData.getConexion();
    }

    public void guardarMiembro(Miembro miembro) {

        String sql = "INSERT INTO miembro (dni, apellido, nombre, estado) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, miembro.getDni());
            ps.setString(2, miembro.getApellido());
            ps.setString(3, miembro.getNombre());
            ps.setBoolean(4, miembro.getEstado()); // if reducido
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                miembro.setIdMiembro(rs.getInt("idMiembro"));
                JOptionPane.showMessageDialog(null, "Miembro cargado exitosamente.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro" + ex.getMessage());
        }

    }

    public void borrarMiembro(int idMiembro) {
        String sql = "DELETE FROM `miembro` WHERE idMiembro = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMiembro);   //Para setear el id donde esta el signo ?
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, " Miembro Borrado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El miembro no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El miembro esta en un equipo ");
        }
    }

}
