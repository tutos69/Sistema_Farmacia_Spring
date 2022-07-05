package ups.edu.ec.Sistema_Farmacia_S.Servicio.Sucursal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Sucursal no encontrado!")
public class SucursalNoEncontradoException extends RuntimeException {


    public SucursalNoEncontradoException() {
    }

    public SucursalNoEncontradoException(String message) {
        super(message);
    }
}




