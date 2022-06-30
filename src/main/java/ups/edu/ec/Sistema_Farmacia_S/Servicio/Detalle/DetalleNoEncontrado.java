package ups.edu.ec.Sistema_Farmacia_S.Servicio.Detalle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Detalle no encontrado!")
public class DetalleNoEncontrado extends RuntimeException{

    public DetalleNoEncontrado() {
    }

    public DetalleNoEncontrado(String message) {
        super(message);
    }
}
