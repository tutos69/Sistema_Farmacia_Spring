package ups.edu.ec.Sistema_Farmacia_S.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Producto;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Producto.ProductoServicio;

import java.util.List;

@RestController
public class ProductoControlador {
    private ProductoServicio productoServicio;

    @Autowired //inyeccion de dependencia
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping("/producto") //obtener el listado de Pedidos
    public ResponseEntity<List<Producto>> getAllProducto() {
        List<Producto> listaProducto = productoServicio.findAll();
        return new ResponseEntity<List<Producto>>(listaProducto, HttpStatus.OK);
    }

    @GetMapping("producto/categoria/{idCategoria}")
    public ResponseEntity<List<Producto>> getProductoByCategoria(@PathVariable int idCategoria){
        List<Producto> listaProducto = productoServicio.findProductobyCategoria(idCategoria);
        return new ResponseEntity<List<Producto>> (listaProducto ,HttpStatus.OK);
    }

    @GetMapping("producto/sucursal/{id}")
    public ResponseEntity<List<Producto>> getProductoBySucursal(@PathVariable int id){
        List<Producto> listaProducto = productoServicio.findProductobySucursal(id);
        return new ResponseEntity<List<Producto>> (listaProducto ,HttpStatus.OK);
    }

}
