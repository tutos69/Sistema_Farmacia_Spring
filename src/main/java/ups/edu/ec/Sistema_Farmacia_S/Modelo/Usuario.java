package ups.edu.ec.Sistema_Farmacia_S.Modelo;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Usuario{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String usuario;
    private String contrasenia;
    private String rol;
    @OneToOne(cascade = CascadeType.PERSIST) //usualmente va en relaciones de onetoOne
    @JoinColumn(name = "entidad_id", nullable = false, referencedColumnName = "id")
    private Entidad entidad;
    @Transient
    private boolean editable;
    public Usuario() {
    }

    public Usuario(int id, String usuario, String contrasenia, String rol, Entidad entidad) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.entidad = entidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
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
        hash = 17 * hash + this.id;
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
        final Usuario other = (Usuario) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", contrasenia=" + contrasenia + ", rol=" + rol + ", entidad=" + entidad + ", editable=" + editable + '}';
    }
}
