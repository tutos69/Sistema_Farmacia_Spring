package ups.edu.ec.Sistema_Farmacia_S.Repositorio;

import org.springframework.data.repository.CrudRepository;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.CarritoDetalle;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.PedidoDetalle;

public interface PedidoDetalleRepositorio extends CrudRepository<PedidoDetalle, Integer> {
}
