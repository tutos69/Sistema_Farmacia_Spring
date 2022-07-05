package ups.edu.ec.Sistema_Farmacia_S.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Pedido;

import java.util.List;

public interface PedidoRepositorio extends CrudRepository<Pedido, Integer> {


    @Query("select p  from Pedido p where p.id = :id")
    Pedido findPedidobyId(int id);

}
