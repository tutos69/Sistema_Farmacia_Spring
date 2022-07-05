package ups.edu.ec.Sistema_Farmacia_S.Servicio.ProductoSucursal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Producto en Sucursal no encontrado!")
public class ProductoSucursalNoEncontradoException extends RuntimeException {

    public ProductoSucursalNoEncontradoException() {
    }

    public ProductoSucursalNoEncontradoException(String message) {
        super(message);
    }
}
