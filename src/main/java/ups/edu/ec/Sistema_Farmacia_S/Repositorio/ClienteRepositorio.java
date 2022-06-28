package ups.edu.ec.Sistema_Farmacia_S.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;

import java.util.List;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {

    @Query("select p.nombre from Cliente p")
    List<String> finallNombres();

}
