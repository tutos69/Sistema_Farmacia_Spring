package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.OneToOne;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "producto_sucursal")
public class ProductoSucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn
    private Sucursal sucursal;
    @OneToOne
    @JoinColumn
    private Producto producto;
    private int stock;

    public ProductoSucursal() {
    }

    public ProductoSucursal(Sucursal sucursal, Producto producto, int stock) {
        this.sucursal = sucursal;
        this.producto = producto;
        this.stock = stock;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        if (!(object instanceof ProductoSucursal)) {
            return false;
        }
        ProductoSucursal other = (ProductoSucursal) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.farmacia.modelo.NewEntity[ id=" + id + " ]";
    }

}
