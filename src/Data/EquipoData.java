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

}
