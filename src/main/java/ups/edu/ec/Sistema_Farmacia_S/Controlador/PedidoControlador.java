package ups.edu.ec.Sistema_Farmacia_S.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.FormaPago;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Pedido;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Pedido.ActualizarPedido;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Pedido.CrearPedido;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Usuario;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.FormaPago.FormaPagoServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Pedido.PedidoNoEncontradoException;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Pedido.PedidoServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Usuario.UsuarioServicio;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController //notacion de spring
public class PedidoControlador {

    private PedidoServicio pedidoServicio;
    private UsuarioServicio usuarioServicio;
    private FormaPagoServicio formaPagoServicio;

    @Autowired //inyeccion de dependencia
    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }

    @Autowired //inyeccion de dependencia
    public void setUsuarioServicio(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @Autowired //inyeccion de dependencia
    public void setFormaPagoServicio(FormaPagoServicio formaPagoServicio) {
        this.formaPagoServicio = formaPagoServicio;
    }



    @GetMapping("/pedidos") //obtener el listado de Pedidos
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> listaPedidos = pedidoServicio.findAll();
        return new ResponseEntity<List<Pedido>>(listaPedidos, HttpStatus.OK);
    }

    @PostMapping("/pedido/create") //crear Pedido
    public ResponseEntity<Pedido> createPedido(@RequestBody CrearPedido crearPedido) {
        Optional<Usuario> usuario = usuarioServicio.findId(crearPedido.getUsuario());
        Optional<FormaPago> formaPago = formaPagoServicio.findById(crearPedido.getFormaPago());
        Pedido pedido = new Pedido();

        if (usuario.isEmpty()){
            return  ResponseEntity.badRequest().build();
        }
        if( formaPago.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        pedido.setUsuario(usuario.get());
        pedido.setLatitud(crearPedido.getLatitud());
        pedido.setLongitud(crearPedido.getLongitud());
        pedido.setEstado(crearPedido.getEstado());
        pedido.setTiempoEspera(crearPedido.getTiempoEspera());
        pedido.setCostoEnvio(crearPedido.getCostoEnvio());
        pedido.setFormaPago(formaPago.get());
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
        Optional <Usuario> usuarioOptional = usuarioServicio.findId(actualizarPedido.getUsuario());
        Optional <FormaPago> formaPagoOptional = formaPagoServicio.findById(actualizarPedido.getFormaPago());
        Pedido pedidoEncontrado = pedidoOptional.get();
        pedidoEncontrado.setUsuario(usuarioOptional.get());
        pedidoEncontrado.setLatitud(actualizarPedido.getLatitud());
        pedidoEncontrado.setLongitud(actualizarPedido.getLongitud());
        pedidoEncontrado.setEstado(actualizarPedido.getEstado());
        pedidoEncontrado.setTiempoEspera(actualizarPedido.getTiempoEspera());
        pedidoEncontrado.setCostoEnvio(actualizarPedido.getCostoEnvio());
        pedidoEncontrado.setDetalles(actualizarPedido.getDetalles());
        pedidoEncontrado.setFormaPago(formaPagoOptional.get());
        pedidoServicio.save(pedidoEncontrado);
        return ResponseEntity.ok(pedidoEncontrado);
    }

    @DeleteMapping("/pedido/delete/{id}")
    public ResponseEntity<String> deletePedido(@PathVariable int id) {
        pedidoServicio.delete(id);
        return ResponseEntity.ok("Pedido eliminado correctamente");
    }



}
