package ups.edu.ec.Sistema_Farmacia_S.Servicio.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Categoria;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Producto;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.ProductoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> findAll(){
        return (List<Producto>) productoRepositorio.findAll();
    }

    public Optional<Producto> findById(int id){
        return (Optional<Producto>) productoRepositorio.findById(id);
    }

    public List<Producto> findProductobyCategoria(int idCategoria){
        return (List<Producto>) productoRepositorio.finallCategoriaProducto(idCategoria);
    }

    public List<Producto> findProductobySucursal(int id){
        return (List<Producto>) productoRepositorio.finallSucursalProducto(id);
    }

    public void save(Producto producto){
        productoRepositorio.save(producto);
    }
}
