package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class FormaPago implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated
    private TipoPago tipoPago;
    private String nombreTitular;
    private String numeroTarjeta;
    private double vuelto;
    private int meses;
    //@OneToOne
    //@JoinColumn
    //private FacturaCabecera facturaCabecera;
    public FormaPago() {
    }

    public FormaPago(int id, TipoPago tipoPago, String nombreTitular, String numeroTarjeta, double vuelto, int meses) {
        this.id = id;
        this.tipoPago = tipoPago;
        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.vuelto = vuelto;
        this.meses = meses;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }


    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public double getVuelto() {
        return vuelto;
    }

    public void setVuelto(double vuelto) {
        this.vuelto = vuelto;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
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
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FormaPago{" + "id=" + id + ", tipoPago=" + tipoPago + ", nombreTitular=" + nombreTitular + ", numeroTarjeta=" + numeroTarjeta + ", vuelto=" + vuelto + ", meses=" + meses + '}';
    }

}
