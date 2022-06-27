package ups.edu.ec.Sistema_Farmacia_S.Modelo;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Usuario usuario;
    private double latitud;
    private double longitud;
    private Detalle detalle;
    private EstadoPedido estado;
    private Date tiempoEspera;
    private double costoEnvio;
    private List<Detalle> detalles;
    private FormaPago formaPago;

    public Pedido() {
    }

    public Pedido(int id, Usuario usuario, double latitud, double longitud, Detalle detalle, EstadoPedido estado, Date tiempoEspera, double costoEnvio, List<Detalle> detalles, FormaPago formaPago) {
        this.id = id;
        this.usuario = usuario;
        this.latitud = latitud;
        this.longitud = longitud;
        this.detalle = detalle;
        this.estado = estado;
        this.tiempoEspera = tiempoEspera;
        this.costoEnvio = costoEnvio;
        this.detalles = detalles;
        this.formaPago = formaPago;
    }



    public Pedido(int id, Usuario usuario, double latitud, double longitud, EstadoPedido estado, Date tiempoEspera, double costoEnvio, List<Detalle> detalles, FormaPago formaPago) {
        this.id = id;
        this.usuario = usuario;
        this.latitud = latitud;
        this.longitud = longitud;
        this.detalle = new Detalle();//Composicion
        this.estado = estado;
        this.tiempoEspera = tiempoEspera;
        this.costoEnvio = costoEnvio;
        this.detalles = detalles;
        this.formaPago = formaPago;
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

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", usuario=" + usuario + ", latitud=" + latitud + ", longitud=" + longitud + ", detalle=" + detalle + ", estado=" + estado + ", tiempoEspera=" + tiempoEspera + ", costoEnvio=" + costoEnvio + ", detalles=" + detalles + ", formaPago=" + formaPago + '}';
    }


}

