
package Entidad;

import java.time.LocalDate;

/**
 *
 * @author Gabriel
 */
public class Tarea {
   private int idTarea;
   private EquipoMiembros equipoMiembros;
   private String nombr;
   private LocalDate fechaCreacion;
   private LocalDate fechaCierre;
   private int estado;

    public Tarea() {
    }

    public Tarea(EquipoMiembros equipoMiembros, String nombr, LocalDate fechaCreacion, LocalDate fechaCierre, int estado) {
        this.equipoMiembros = equipoMiembros;
        this.nombr = nombr;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
    }

    public Tarea(int idTarea, EquipoMiembros equipoMiembros, String nombr, LocalDate fechaCreacion, LocalDate fechaCierre, int estado) {
        this.idTarea = idTarea;
        this.equipoMiembros = equipoMiembros;
        this.nombr = nombr;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public EquipoMiembros getEquipoMiembros() {
        return equipoMiembros;
    }

    public void setEquipoMiembros(EquipoMiembros equipoMiembros) {
        this.equipoMiembros = equipoMiembros;
    }

    public String getNombr() {
        return nombr;
    }

    public void setNombr(String nombr) {
        this.nombr = nombr;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", equipoMiembros=" + equipoMiembros + ", nombr=" + nombr + ", fechaCreacion=" + fechaCreacion + ", fechaCierre=" + fechaCierre + ", estado=" + estado + '}';
    }
   
   
}
