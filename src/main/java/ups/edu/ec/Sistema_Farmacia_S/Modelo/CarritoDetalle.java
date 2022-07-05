package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "carrito_detalle")
public class CarritoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn
    private ProductoSucursal productoSucursal;
    private int cantidad;
    private double precio;
    private double subtotal;
    @ManyToOne
    @JoinColumn(name="carrito_cabecera")
    private CarritoCabecera carritoCabecera;


    public CarritoDetalle() {
    }

    public CarritoDetalle(ProductoSucursal productoSucursal, int cantidad, double precio, double subtotal) {
        this.productoSucursal = productoSucursal;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public CarritoCabecera getCarritoCabecera() {
        return carritoCabecera;
    }

    public void setCarritoCabecera(CarritoCabecera carritoCabecera) {
        this.carritoCabecera = carritoCabecera;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public ProductoSucursal getProductoSucursal() {
        return productoSucursal;
    }

    public void setProductoSucursal(ProductoSucursal productoSucursal) {
        this.productoSucursal = productoSucursal;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
        final CarritoDetalle other = (CarritoDetalle) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "CarritoDetalle{" + "id=" + id + ", productoSucursal=" + productoSucursal + ", cantidad=" + cantidad + ", precio=" + precio + ", subtotal=" + subtotal + '}';
    }



}
