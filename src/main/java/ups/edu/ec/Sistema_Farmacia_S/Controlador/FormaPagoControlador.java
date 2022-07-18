package ups.edu.ec.Sistema_Farmacia_S.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.FormaPago;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Pedido;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.FormaPago.ActualizarFormaPago;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.FormaPago.CrearFormaPago;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Pedido.ActualizarPedido;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Usuario;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.FormaPagoRepositorio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.CarritoCabecera.CarritoCabeceraServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.CarritoDetalle.CarritoDetalleServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Cliente.ClienteServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.FormaPago.FormaPagoNoEncontradoException;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.FormaPago.FormaPagoServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Pedido.PedidoNoEncontradoException;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Pedido.PedidoServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.PedidoDetalle.PedidoDetalleServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Usuario.UsuarioServicio;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController //notacion de Spring
public class FormaPagoControlador {

    private FormaPagoServicio formaPagoServicio;

    private PedidoServicio pedidoServicio;
    private UsuarioServicio usuarioServicio;


    private UsuarioControlador usuarioControlador;

    private CarritoCabeceraServicio carritoCabeceraServicio;

    private CarritoDetalleServicio carritoDetalleServicio;

    private PedidoDetalleServicio pedidoDetalleServicio;

    private ClienteServicio clienteServicio;

    @Autowired
    public void setClienteServicio(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @Autowired
    public void setUsuarioControlador(UsuarioControlador usuarioControlador) {
        this.usuarioControlador = usuarioControlador;
    }
    @Autowired
    public void setCarritoCabeceraServicio(CarritoCabeceraServicio carritoCabeceraServicio) {
        this.carritoCabeceraServicio = carritoCabeceraServicio;
    }
    @Autowired
    public void setCarritoDetalleServicio(CarritoDetalleServicio carritoDetalleServicio) {
        this.carritoDetalleServicio = carritoDetalleServicio;
    }
    @Autowired
    public void setPedidoDetalleServicio(PedidoDetalleServicio pedidoDetalleServicio) {
        this.pedidoDetalleServicio = pedidoDetalleServicio;
    }

    @Autowired //inyeccion de dependencia
    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }

    @Autowired //inyeccion de dependencia
    public void setUsuarioServicio(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }


    @Autowired
    public void setFormaPagoServicio(FormaPagoServicio formaPagoServicio) {
        this.formaPagoServicio = formaPagoServicio;
    }

    @GetMapping("/formasDePago/{usuario}") //obtener el listado de Formas de Pago
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<FormaPago>> getAllFormaPagos(@PathVariable String usuario) {
            Usuario u = usuarioServicio.EncontrarUsuarioUser(usuario);
            if (u == null) {
                return ResponseEntity.badRequest().build();
            }
            Cliente c = clienteServicio.buscaIdCliente(u.getEntidad().getIdentificador());
            if (c == null) {
                return ResponseEntity.badRequest().build();
            }
            List<FormaPago> listaFormasPago = formaPagoServicio.findAll();
            List<FormaPago> listaFormasPagoUsuario = new ArrayList<>();
            System.out.println(listaFormasPago);
            for (FormaPago Fo : listaFormasPago) {

                if (Fo.getId() == c.getFormaPago().getId()) {
                    listaFormasPagoUsuario.add(Fo);
                }
            }
            return new ResponseEntity<List<FormaPago>>(listaFormasPagoUsuario, HttpStatus.OK);
        }

    @PostMapping("/formaPago/create") //Crear Forma De Pago
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<FormaPago> createFormaPago(@RequestBody CrearFormaPago crearFormaPago, HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("Usuario");
        FormaPago formaPago = new FormaPago();
        formaPago.setTipoPago(crearFormaPago.getTipoPago());
        formaPago.setMeses(crearFormaPago.getMeses());
        formaPago.setVuelto(crearFormaPago.getVuelto());
        formaPago.setNombreTitular(crearFormaPago.getNombreTitular());
        formaPago.setNumeroTarjeta(crearFormaPago.getNumeroTarjeta());
        formaPagoServicio.save(formaPago);
        Cliente cliente= clienteServicio.buscaIdCliente(usuario.getEntidad().getIdentificador());
        cliente.setFormaPago(formaPago);
        clienteServicio.Crear(cliente);
        return ResponseEntity.ok(formaPago);
    }

    @PostMapping("/formaPago/create1") //Crear Forma De Pago
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<FormaPago> createFormaPago1(@RequestBody CrearFormaPago crearFormaPago, HttpSession httpSession) {
        Usuario usuario = usuarioServicio.EncontrarUsuarioUser(crearFormaPago.getUsuario());
        if (usuario==null){
            return ResponseEntity.badRequest().build();
        }
        FormaPago formaPago = new FormaPago();
        formaPago.setTipoPago(crearFormaPago.getTipoPago());
        formaPago.setMeses(crearFormaPago.getMeses());
        formaPago.setVuelto(crearFormaPago.getVuelto());
        formaPago.setNombreTitular(crearFormaPago.getNombreTitular());
        formaPago.setNumeroTarjeta(crearFormaPago.getNumeroTarjeta());
        formaPagoServicio.save(formaPago);
        Cliente cliente= clienteServicio.buscaIdCliente(usuario.getEntidad().getIdentificador());
        cliente.setFormaPago(formaPago);
        clienteServicio.Crear(cliente);
        return ResponseEntity.ok(formaPago);
    }

    @PutMapping("/formaPago/update")
    public ResponseEntity<FormaPago> updateFormaPago(@RequestBody ActualizarFormaPago actualizarFormaPago) {
        Optional<FormaPago> formaPagoOptional = formaPagoServicio.findById(actualizarFormaPago.getId());
        if (formaPagoOptional.isEmpty()) {
            FormaPago formaPago = formaPagoOptional.orElseThrow(FormaPagoNoEncontradoException::new);
            return new ResponseEntity<FormaPago>(formaPago, HttpStatus.OK);
        }
        FormaPago formaPagoEncontrada = formaPagoOptional.get();
        formaPagoEncontrada.setTipoPago(actualizarFormaPago.getTipoPago());
        formaPagoEncontrada.setMeses(actualizarFormaPago.getMeses());
        formaPagoEncontrada.setVuelto(actualizarFormaPago.getVuelto());
        formaPagoEncontrada.setNombreTitular(actualizarFormaPago.getNombreTitular());
        formaPagoEncontrada.setNumeroTarjeta(actualizarFormaPago.getNumeroTarjeta());
        formaPagoServicio.save(formaPagoEncontrada);
        return ResponseEntity.ok(formaPagoEncontrada);
    }

    @DeleteMapping("/formaPago/delete/{id}")
    public ResponseEntity<String> deleteFormaPago(@PathVariable int id) {
        formaPagoServicio.delete(id);
        return ResponseEntity.ok("Forma de Pago  eliminada correctamente");
    }
}
