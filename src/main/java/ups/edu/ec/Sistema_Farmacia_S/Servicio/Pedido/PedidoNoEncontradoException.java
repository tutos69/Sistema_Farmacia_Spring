package ups.edu.ec.Sistema_Farmacia_S.Servicio.Pedido;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Pedido no encontrado!")
public class PedidoNoEncontradoException extends  RuntimeException {
    public PedidoNoEncontradoException() {
    }

    public PedidoNoEncontradoException(String message) {
        super(message);
    }
}
