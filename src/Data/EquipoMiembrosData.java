package Data;

import Entidad.EquipoMiembros;
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

}
