package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author pcuser
 */
@Entity
public class CabeceraVenta extends FacturaCabecera implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabeceraVenta")
    private List<Detalle> detalles;
    @OneToOne
    @JoinColumn
    private Cliente cliente;

    public CabeceraVenta(Cliente cliente, int id, Date fecha, double subtotal, double total, boolean estado) {
        super(id, fecha, subtotal, total, estado);
        this.cliente = cliente;
    }

    public CabeceraVenta(List<Detalle> detalles, int id, Date fecha, double subtotal, double total, boolean estado) {
        super(id, fecha, subtotal, total, estado);
        this.detalles = detalles;
    }

    public CabeceraVenta(int id, Date fecha, double subtotal, double total, boolean estado) {
        super(id, fecha, subtotal, total, estado);

        this.detalles = new ArrayList<>();

    }

    public CabeceraVenta(List<Detalle> detalles, Cliente cliente, int id, Date fecha, double subtotal, double total, boolean estado) {
        super(id, fecha, subtotal, total, estado);
        this.detalles = detalles;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public CabeceraVenta() {
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public void addDetalle(Detalle d) {
        this.detalles.add(d);
    }

}

