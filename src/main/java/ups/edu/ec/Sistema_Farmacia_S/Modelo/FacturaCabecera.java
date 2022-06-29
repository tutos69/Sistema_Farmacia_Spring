package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author pcuser
 */
@Entity
@Table(name = "factura_Cabecera")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class FacturaCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private double subtotal;
    private double total;
    private boolean estado;
    // @OneToOne(cascade = CascadeType.ALL, mappedBy = "facturaCabecera")
    //private FormaPago formaPago;

    public FacturaCabecera(int id, Date fecha, double subtotal, double total, boolean estado) {
        this.id = id;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.estado = estado;
    }

    public FacturaCabecera() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
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
        final FacturaCabecera other = (FacturaCabecera) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "FacturaCabecera{" + "id=" + id + ", fecha=" + fecha + ", subtotal=" + subtotal + ", total=" + total + ", estado=" + estado + '}';
    }


}
