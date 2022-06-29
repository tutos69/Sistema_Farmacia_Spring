package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "compra")
public class CabeceraCompra  extends FacturaCabecera implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabeceraCompra")
    private List<Detalle> detalles;
    @OneToOne
    @JoinColumn
    private Proveedor proveedor;

    public CabeceraCompra() {
    }

    public CabeceraCompra(Proveedor proveedor, int id, Date fecha, double subtotal, double total, boolean estado) {
        super(id, fecha, subtotal, total, estado);
        this.proveedor = proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }


}
