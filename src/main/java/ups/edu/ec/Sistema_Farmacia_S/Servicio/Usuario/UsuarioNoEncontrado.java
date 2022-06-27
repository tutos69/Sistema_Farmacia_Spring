package ups.edu.ec.Sistema_Farmacia_S.Servicio.Usuario;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Usuario no encontrado!")
public class UsuarioNoEncontrado extends RuntimeException{
    public UsuarioNoEncontrado() {
    }

    public UsuarioNoEncontrado(String message) {
        super(message);
    }
}
