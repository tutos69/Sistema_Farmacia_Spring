package ups.edu.ec.Sistema_Farmacia_S.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Pedido;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Pedido.ActualizarPedido;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Pedido.CrearPedido;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Pedido.PedidoNoEncontradoException;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Pedido.PedidoServicio;

import java.util.List;
import java.util.Optional;

@RestController //notacion de spring
public class PedidoControlador {

    private PedidoServicio pedidoServicio;

    @Autowired //inyeccion de dependencia
    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }

    @GetMapping("/pedidos") //obtener el listado de Pedidos
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> listaPedidos = pedidoServicio.findAll();
        return new ResponseEntity<List<Pedido>>(listaPedidos, HttpStatus.OK);
    }

    @PostMapping("/pedido/create") //crear Pedido
    public ResponseEntity<Pedido> createPedido(@RequestBody CrearPedido crearPedido) {
        Pedido pedido = new Pedido();
        pedido.setUsuario(crearPedido.getUsuario());
        pedido.setLatitud(crearPedido.getLatitud());
        pedido.setLongitud(crearPedido.getLongitud());
        pedido.setEstado(crearPedido.getEstado());
        pedido.setTiempoEspera(crearPedido.getTiempoEspera());
        pedido.setCostoEnvio(crearPedido.getCostoEnvio());
        pedido.setDetalles(crearPedido.getDetalles());
        pedido.setFormaPago(crearPedido.getFormaPago());
        pedidoServicio.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/pedido/update")
    public ResponseEntity<Pedido> updatePedido(@RequestBody ActualizarPedido actualizarPedido) {
        Optional<Pedido> pedidoOptional = pedidoServicio.findById(actualizarPedido.getId());
        if (pedidoOptional.isEmpty()) {
            Pedido pedido =pedidoOptional.orElseThrow(PedidoNoEncontradoException::new);
            return new ResponseEntity <Pedido>(pedido,HttpStatus.OK);
        }
        Pedido pedidoEncontrado = pedidoOptional.get();
        pedidoEncontrado.setUsuario(actualizarPedido.getUsuario());
        pedidoEncontrado.setLatitud(actualizarPedido.getLatitud());
        pedidoEncontrado.setLongitud(actualizarPedido.getLongitud());
        pedidoEncontrado.setEstado(actualizarPedido.getEstado());
        pedidoEncontrado.setTiempoEspera(actualizarPedido.getTiempoEspera());
        pedidoEncontrado.setCostoEnvio(actualizarPedido.getCostoEnvio());
        pedidoEncontrado.setDetalles(actualizarPedido.getDetalles());
        pedidoEncontrado.setFormaPago(actualizarPedido.getFormaPago());
        pedidoServicio.save(pedidoEncontrado);
        return ResponseEntity.ok(pedidoEncontrado);
    }

    @DeleteMapping("/pedido/delete/{id}")
    public ResponseEntity<String> deletePedido(@PathVariable int id) {
        pedidoServicio.delete(id);
        return ResponseEntity.ok("Pedido eliminado correctamente");
    }



}
