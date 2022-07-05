package ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.EstadoPedido;

import java.util.Date;

public class CrearPedido {
    @JsonProperty
    private int usuario;
    @JsonProperty
    private double latitud;
    @JsonProperty
    private double longitud;

    @JsonProperty
    private EstadoPedido estado;
    @JsonProperty
    private Date tiempoEspera;
    @JsonProperty
    private double costoEnvio;

    @JsonProperty
    private int formaPago;

    public CrearPedido() {
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Date getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(Date tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }


}
