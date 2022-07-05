package ups.edu.ec.Sistema_Farmacia_S.Servicio.Producto;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Producto no encontrado!")
public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException() {
    }

    public ProductoNoEncontradoException(String message) {
        super(message);
    }
}
