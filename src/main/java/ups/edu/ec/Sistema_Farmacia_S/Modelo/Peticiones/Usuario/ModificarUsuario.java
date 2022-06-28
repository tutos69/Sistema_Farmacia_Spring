package ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModificarUsuario {
    @JsonProperty
    private int id;
    @JsonProperty
    private String usuario;
    @JsonProperty
    private String contrasenia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
