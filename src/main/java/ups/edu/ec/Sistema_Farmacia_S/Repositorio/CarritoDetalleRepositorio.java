package ups.edu.ec.Sistema_Farmacia_S.Repositorio;

import org.springframework.data.repository.CrudRepository;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.CarritoCabecera;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.CarritoDetalle;

public interface CarritoDetalleRepositorio extends CrudRepository<CarritoDetalle, Integer> {
}
