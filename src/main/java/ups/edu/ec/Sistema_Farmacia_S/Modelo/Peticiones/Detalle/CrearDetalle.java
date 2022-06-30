package ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Detalle;

import com.fasterxml.jackson.annotation.JsonProperty;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.*;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class CrearDetalle {
    @JsonProperty
    private int producto;
    @JsonProperty
    private int cantidad;
    @JsonProperty
    private double precio;
    @JsonProperty
    private double subtotal;
    @JsonProperty
    private CabeceraVenta cabeceraVenta;
    @JsonProperty
    private CabeceraCompra cabeceraCompra;
    @JsonProperty
    private Kardex kardex;
    @JsonProperty
    private int pedido;

    public CrearDetalle() {
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
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

    public CabeceraVenta getCabeceraVenta() {
        return cabeceraVenta;
    }

    public void setCabeceraVenta(CabeceraVenta cabeceraVenta) {
        this.cabeceraVenta = cabeceraVenta;
    }

    public CabeceraCompra getCabeceraCompra() {
        return cabeceraCompra;
    }

    public void setCabeceraCompra(CabeceraCompra cabeceraCompra) {
        this.cabeceraCompra = cabeceraCompra;
    }

    public Kardex getKardex() {
        return kardex;
    }

    public void setKardex(Kardex kardex) {
        this.kardex = kardex;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }
}
