package ups.edu.ec.Sistema_Farmacia_S.Servicio.FormaPago;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Forma de pago no encontrada!")
public class FormaPagoNoEncontradoException extends RuntimeException {
    public FormaPagoNoEncontradoException() {
    }
    public FormaPagoNoEncontradoException(String message) {
        super(message);
    }
}
