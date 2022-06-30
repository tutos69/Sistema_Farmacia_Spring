package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Detalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    private int cantidad;
    private double precio;
    private double subtotal;
    @ManyToOne
    @JoinColumn //(name = "cabeceraa_id", nullable = true, referencedColumnName = "id")
    private CabeceraVenta cabeceraVenta;
    @ManyToOne
    @JoinColumn(name = "cabeceraa_id", nullable = true, referencedColumnName = "id")
    private CabeceraCompra cabeceraCompra;
    @OneToOne(cascade =CascadeType.ALL ,mappedBy ="detalle" )
    private Kardex kardex;
    @ManyToOne
    @JoinColumn
    private Pedido pedido;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Detalle() {
    }

    public Detalle(int id, Producto producto, int cantidad, double precio, double subtotal, CabeceraVenta cabeceraVenta, CabeceraCompra cabeceraCompra, Kardex kardex, Pedido pedido) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.cabeceraVenta = cabeceraVenta;
        this.cabeceraCompra = cabeceraCompra;
        this.kardex = kardex;
        this.pedido = pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Detalle{" + "id=" + id +  ", cantidad=" + cantidad + ", precio=" + precio + ", subtotal=" + subtotal + '}';
    }

}
