package ups.edu.ec.Sistema_Farmacia_S.Servicio.Cliente;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Cliente no encontrado!")
public class ClienteNoEncontrado extends RuntimeException{
    public ClienteNoEncontrado() {
    }

    public ClienteNoEncontrado(String message) {
        super(message);
    }
}
