
package Entidad;

/**
 *
 * @author Gabriel
 */
public class Miembro {
   private int idMiembro;
   private int dni;
   private String nombre;
   private String apellido;
   private Boolean estado;

    public Miembro() {
    }

    public Miembro(int dni, String nombre, String apellido, Boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public Miembro(int idMiembro, int dni, String nombre, String apellido, Boolean estado) {
        this.idMiembro = idMiembro;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Miembro{" + "idMiembro=" + idMiembro + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", estado=" + estado + '}';
    }
   
}
