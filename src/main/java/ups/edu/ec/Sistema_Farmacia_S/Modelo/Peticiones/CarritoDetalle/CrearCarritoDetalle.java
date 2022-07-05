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
}
