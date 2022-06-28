package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedQuery(name = "getByLevel",
        query = "SELECT c FROM Cliente c WHERE c.id >= :level")
@Entity
@Table(name = "cliente")
public class Cliente extends Entidad{

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
    //private CabeceraVenta cabeceraVenta;

    public Cliente() {
    }

    public Cliente(Date fechaNacimiento, int id, String identificador, String nombre, String apellido, String correo, String direccion, String telefono) {
        super(id, identificador, nombre, apellido, correo, direccion, telefono);
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " Apellido: " + getApellido() + " Cedula: " + getIdentificador() + " Direccion= " + getDireccion() + '}';
    }

}