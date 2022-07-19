package ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.CarritoDetalle;
import com.fasterxml.jackson.annotation.JsonProperty;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.CarritoCabecera;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.ProductoSucursal;

import javax.persistence.*;

public class CrearCarritoDetalle {

    @JsonProperty
    private String nombreProductoSucursal;
    @JsonProperty
    private int cantidad;

    @JsonProperty
    private String usuario;

    @JsonProperty
    private String sucursal;

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombreProductoSucursal() {
        return nombreProductoSucursal;
    }

    public void setNombreProductoSucursal(String nombreProductoSucursal) {
        this.nombreProductoSucursal = nombreProductoSucursal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
