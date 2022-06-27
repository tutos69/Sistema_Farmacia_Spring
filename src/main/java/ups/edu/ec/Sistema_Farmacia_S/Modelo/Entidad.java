package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import javax.persistence.*;
@Entity
@Table(name = "entidad")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Entidad {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "identificador", nullable = false, unique = true, length = 13)
    private String identificador;
    private String nombre;
    private String apellido;
    @Column(name = "correo")
    private String correo;
    private String direccion;
    private String telefono;
    @Transient
    private boolean editable;

    public Entidad() {
    }

    public Entidad(int id, String identificador, String nombre, String apellido, String correo, String direccion, String telefono) {
        this.id = id;
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Entidad(int id, String identificador, String nombre, String correo, String direccion, String telefono) {
        this.id = id;
        this.identificador = identificador;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entidad other = (Entidad) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Entidad{" + "id=" + id + ", identificador=" + identificador + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
}
