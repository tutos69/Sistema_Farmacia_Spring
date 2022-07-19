package ups.edu.ec.Sistema_Farmacia_S.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Producto;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Sucursal;

import java.util.List;

public interface SucursalRepositorio  extends CrudRepository<Sucursal, Integer> {

    @Query("select s from Sucursal s where s.nombreClave=:nombreClave ")
    Sucursal recuperarSucursal(String nombreClave);
}
