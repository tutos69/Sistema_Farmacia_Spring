package ups.edu.ec.Sistema_Farmacia_S.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Detalle;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Pedido;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Detalle.CrearDetalle;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Producto;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Detalle.DetalleServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Pedido.PedidoServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Producto.ProductoServicio;

import java.util.Optional;

@RestController
public class DetalleControlador {

    private DetalleServicio detalleServicio;
    private ProductoServicio productoServicio;
    private PedidoServicio pedidoServicio;

    @Autowired
    public void setDetalleServicio(DetalleServicio detalleServicio) {
        this.detalleServicio = detalleServicio;
    }

    @Autowired
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @Autowired
    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }

    @PostMapping("/detalle/create") //crear Detalle
    public ResponseEntity<Detalle> createDetalle(@RequestBody CrearDetalle crearDetalle) {
        Optional<Producto> producto = productoServicio.findById(crearDetalle.getProducto());
        System.out.printf(String.valueOf(producto.get()));
        if (producto.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Optional<Pedido> pedido = pedidoServicio.findById(crearDetalle.getPedido());
        System.out.printf(String.valueOf(pedido.get()));

        if (pedido.isEmpty()){
            System.out.println("sdfdsfds");
            return ResponseEntity.badRequest().build();

        }
        Detalle detalle = new Detalle();
        detalle.setCantidad(crearDetalle.getCantidad());
        detalle.setPrecio(crearDetalle.getPrecio());
        detalle.setProducto(producto.get());
        detalle.setSubtotal(crearDetalle.getSubtotal());;
        detalle.setPedido(pedido.get());
        detalleServicio.Crear(detalle);
        return ResponseEntity.ok(detalle);
    }
}
