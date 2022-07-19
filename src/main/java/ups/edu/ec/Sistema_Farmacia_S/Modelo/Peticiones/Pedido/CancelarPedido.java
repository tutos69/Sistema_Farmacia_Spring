package ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CancelarPedido {
    @JsonProperty
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
