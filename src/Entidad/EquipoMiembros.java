
package Entidad;

import java.time.LocalDate;

/**
 *
 * @author Gabriel
 */
public class EquipoMiembros {
   private int idEquipoMiembros;
   private Equipo equipo;
   private Miembro miembro;
   private LocalDate fechaIncorporacion;

    public EquipoMiembros() {
    }

    public EquipoMiembros(Equipo equipo, Miembro miembro, LocalDate fechaIncorporacion) {
        this.equipo = equipo;
        this.miembro = miembro;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public EquipoMiembros(int idEquipoMiembros, Equipo equipo, Miembro miembro, LocalDate fechaIncorporacion) {
        this.idEquipoMiembros = idEquipoMiembros;
        this.equipo = equipo;
        this.miembro = miembro;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public int getIdEquipoMiembros() {
        return idEquipoMiembros;
    }

    public void setIdEquipoMiembros(int idEquipoMiembros) {
        this.idEquipoMiembros = idEquipoMiembros;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public String toString() {
        return "EquipoMiembros{" + "idEquipoMiembros=" + idEquipoMiembros + ", equipo=" + equipo.getNombre() + ", miembro=" + miembro.getNombre() + ", fechaIncorporacion=" + fechaIncorporacion + '}';
    }
   
}
