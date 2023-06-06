package Data;

import Entidad.Miembro;
import Entidad.Tarea;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class TareaData {

    private Connection con = null;

    public TareaData() {
        con = ConeccionData.getConexion();
    }

    public void guardarTarea(Tarea tarea) {

        String sql = "INSERT INTO tarea (idEquipoMiembro, nombre, fechaCreacion, fechaCierre,estado) VALUES (?, ?, ?, ?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tarea.getEquipoMiembros().getIdEquipoMiembros());
            ps.setString(2, tarea.getNombr());
            ps.setDate(3, Date.valueOf(tarea.getFechaCreacion())); // pasar de localdate a date para sql
            ps.setDate(4, Date.valueOf(tarea.getFechaCierre())); 
            ps.setInt(5, 1);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                tarea.setIdTarea(rs.getInt("idTarea"));
                JOptionPane.showMessageDialog(null, "Tarea cargada exitosamente.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tarea" + ex.getMessage());
        }

    }

}
