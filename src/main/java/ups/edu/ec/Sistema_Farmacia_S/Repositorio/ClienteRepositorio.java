package ups.edu.ec.Sistema_Farmacia_S.Repositorio;

import org.springframework.data.repository.CrudRepository;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {
}
