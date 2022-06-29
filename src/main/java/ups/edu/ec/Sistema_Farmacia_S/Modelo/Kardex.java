package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Kardex implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn
    private Detalle detalle;
    private String signo;
    private double PrecioPonderado;

    public Kardex() {
    }

    public Kardex(int id, Detalle detalle, String signo, double PrecioPonderado) {
        this.id = id;
        this.detalle = detalle;
        this.signo = signo;
        this.PrecioPonderado = PrecioPonderado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }



    public double getPrecioPonderado() {
        return PrecioPonderado;
    }

    public void setPrecioPonderado(double PrecioPonderado) {
        this.PrecioPonderado = PrecioPonderado;
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
        if (!(object instanceof Kardex)) {
            return false;
        }
        Kardex other = (Kardex) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }



}
