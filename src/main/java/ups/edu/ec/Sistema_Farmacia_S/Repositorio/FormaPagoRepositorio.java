package ups.edu.ec.Sistema_Farmacia_S.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.FormaPago;


public interface FormaPagoRepositorio extends CrudRepository<FormaPago,Integer> {
    @Query("select f from FormaPago f where f.id =:id")
    FormaPago findFormaPagobyId(int id);
}
