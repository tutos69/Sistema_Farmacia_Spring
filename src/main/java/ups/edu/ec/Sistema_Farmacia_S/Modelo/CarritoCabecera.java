package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "carrito_cabecera")
public class CarritoCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn
    private Usuario usuario;
    @OneToOne
    @JoinColumn
    private Entidad entidad;
    private double subtotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carritoCabecera")
    @JsonIgnore
    private List<CarritoDetalle> listaDetalle;

    public CarritoCabecera() {
    }

    public CarritoCabecera(int id, Usuario usuario, Entidad entidad, int subtotal, List<CarritoDetalle> listaDetalle) {
        this.id = id;
        this.usuario = usuario;
        this.entidad = entidad;
        this.subtotal = subtotal;
        this.listaDetalle = listaDetalle;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public List<CarritoDetalle> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<CarritoDetalle> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }



}
