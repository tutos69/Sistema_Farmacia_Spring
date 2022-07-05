package ups.edu.ec.Sistema_Farmacia_S.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Producto;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.ProductoSucursal;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Sucursal;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Usuario;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Producto.ProductoServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.ProductoSucursal.ProductoSucursalServicio;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoControlador {
    private ProductoServicio productoServicio;

     private ProductoSucursalServicio productoSucursalServicio;
    @Autowired
    public void setProductoSucursalServicio(ProductoSucursalServicio productoSucursalServicio) {
        this.productoSucursalServicio = productoSucursalServicio;
    }

    @Autowired //inyeccion de dependencia
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping("/producto") //obtener el listado de Pedidos
    public ResponseEntity<List<Producto>> getAllProducto() {
        List<Producto> listaProducto = productoServicio.findAll();
        return new ResponseEntity<List<Producto>>(listaProducto, HttpStatus.OK);
    }

    @GetMapping("producto/categoria/{nombreCategoria}")
    public ResponseEntity<List<ProductoSucursal>> getProductoByCategoria(@PathVariable String nombreCategoria, HttpSession httpSession) {
        Sucursal sucursal = (Sucursal) httpSession.getAttribute("Sucursal");

        List<ProductoSucursal> listaProducto = productoSucursalServicio.findAll();
        List<ProductoSucursal> listaDeProductosPorCategoria = new ArrayList<>();
        for (ProductoSucursal productoSucursal: listaProducto
             ) {
            System.out.println(productoSucursal);
            if(productoSucursal.getSucursal().equals(sucursal) && productoSucursal.getProducto().getCategoria().getNombre().equals(nombreCategoria)){
                listaDeProductosPorCategoria.add(productoSucursal);
            }


        }


        return new ResponseEntity<List<ProductoSucursal>>(listaDeProductosPorCategoria, HttpStatus.OK);
    }



}
