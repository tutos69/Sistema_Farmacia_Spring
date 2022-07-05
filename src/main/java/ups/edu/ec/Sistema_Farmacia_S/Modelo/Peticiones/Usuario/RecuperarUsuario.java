package ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Usuario;


import com.fasterxml.jackson.annotation.JsonProperty;
public class RecuperarUsuario {

    @JsonProperty
    private String usuario;
    @JsonProperty
    private String contrasenia;


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
