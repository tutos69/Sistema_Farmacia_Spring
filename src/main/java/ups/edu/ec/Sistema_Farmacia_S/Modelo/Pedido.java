package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private double latitud;
    private double longitud;
    @Enumerated
    private EstadoPedido estado;
    @Column(name = "tiempo_Espera")
    @Temporal(TemporalType.DATE)
    private Date tiempoEspera;
    private double costoEnvio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
   // @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<Detalle> detalles;
    @OneToOne
    @JoinColumn(name = "forma_pago_id")
    private FormaPago formaPago;

    public Pedido() {
    }

    public Pedido(int id, Usuario usuario, double latitud, double longitud, EstadoPedido estado, Date tiempoEspera, double costoEnvio, List<Detalle> detalles, FormaPago formaPago) {
        this.id = id;
        this.usuario = usuario;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estado = estado;
        this.tiempoEspera = tiempoEspera;
        this.costoEnvio = costoEnvio;
        this.detalles = detalles;
        this.formaPago = formaPago;
    }

    public Pedido(int id, Usuario usuario, double latitud, double longitud, EstadoPedido estado, Date tiempoEspera, double costoEnvio, FormaPago formaPago) {
        this.id = id;
        this.usuario = usuario;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estado = estado;
        this.tiempoEspera = tiempoEspera;
        this.costoEnvio = costoEnvio;
        this.detalles = new ArrayList<>(); //Composicion
        this.formaPago = formaPago;
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

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Date getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(Date tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id == pedido.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
