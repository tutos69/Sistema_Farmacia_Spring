package ups.edu.ec.Sistema_Farmacia_S.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Categoria;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Producto;

import java.util.List;

public interface ProductoRepositorio extends CrudRepository<Producto,Integer> {

    @Query("select p from Producto p where p.categoria.id=:idCategoria")
    List<Producto> finallCategoriaProducto(int idCategoria);

    @Query("select p from Producto p where p.sucursal.id=:id")
    List<Producto> finallSucursalProducto(int id);
}
