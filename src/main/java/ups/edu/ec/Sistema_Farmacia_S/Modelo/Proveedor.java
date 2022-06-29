package ups.edu.ec.Sistema_Farmacia_S.Modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 *
 * @author ASUS_GAMING
 */
@Entity
public class Proveedor extends Entidad implements Serializable {

    private String sitioWeb;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private CabeceraCompra cabeceraCompra;

    public Proveedor() {
    }

    public Proveedor(String sitioWeb, int id, String identificador, String nombre, String correo, String direccion, String telefono) {
        super(id, identificador, nombre, correo, direccion, telefono);
        this.sitioWeb = sitioWeb;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

}
