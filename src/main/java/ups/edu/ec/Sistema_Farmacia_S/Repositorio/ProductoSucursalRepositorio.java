package ups.edu.ec.Sistema_Farmacia_S.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Producto;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.ProductoSucursal;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.ProductoSucursal.ProductoSucursalServicio;

import java.util.List;

public interface ProductoSucursalRepositorio extends CrudRepository<ProductoSucursal, Integer> {

}
