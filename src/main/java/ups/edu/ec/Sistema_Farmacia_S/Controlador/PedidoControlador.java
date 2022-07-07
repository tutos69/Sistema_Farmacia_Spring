package ups.edu.ec.Sistema_Farmacia_S.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.*;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Pedido.ActualizarPedido;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Pedido.CrearPedido;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Pedido.FacturarAlguienMas;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.CarritoCabecera.CarritoCabeceraServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.CarritoDetalle.CarritoDetalleServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Cliente.ClienteServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.FormaPago.FormaPagoServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Pedido.PedidoNoEncontradoException;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Pedido.PedidoServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.PedidoDetalle.PedidoDetalleServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Usuario.UsuarioServicio;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Usuario;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController //notacion de spring
public class PedidoControlador {

    private PedidoServicio pedidoServicio;
    private UsuarioServicio usuarioServicio;
    private FormaPagoServicio formaPagoServicio;

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

    @Autowired //inyeccion de dependencia
    public void setFormaPagoServicio(FormaPagoServicio formaPagoServicio) {
        this.formaPagoServicio = formaPagoServicio;
    }


    @GetMapping("/pedidos") //obtener el listado de Pedidos
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> listaPedidos = pedidoServicio.findAll();
        return new ResponseEntity<List<Pedido>>(listaPedidos, HttpStatus.OK);
    }

    @GetMapping("pedido/usuario") //obtener el listado de Pedidos
    public ResponseEntity<Usuario> getUsuario(HttpSession httpSession) {

        Usuario usuario = (Usuario) httpSession.getAttribute("Usuario");
       // Usuario usuario = usuarioControlador.getUsuario();
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PostMapping("/pedido/create") //crear Pedido
    public ResponseEntity<Pedido> createPedido(@RequestBody CrearPedido crearPedido) {
        Optional<Usuario> usuario = usuarioServicio.findId(crearPedido.getUsuario());
        Optional<FormaPago> formaPago = formaPagoServicio.findById(crearPedido.getFormaPago());
        Pedido pedido = new Pedido();

        if (usuario.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        if (formaPago.isEmpty()) {
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

    @GetMapping("pedido/enviar")
    public  ResponseEntity<String> enviarPedido(HttpSession httpSession){
        Usuario usuario = (Usuario) httpSession.getAttribute("Usuario");
        CarritoCabecera carritoCabecera= recuperarCarritoCabecera(usuario);
        Pedido pedido = new Pedido();
        PedidoDetalle pedidoDetalle = new PedidoDetalle();

        pedido.setUsuario(usuario);
        pedido.setEstado(EstadoPedido.RECIBIDO);

        pedido.setLatitud(0);
        pedido.setLongitud(0);
        pedido.setCostoEnvio(0);
        pedido.setTiempoEspera(null);
        pedido.setTotal(carritoCabecera.getSubtotal());

        pedido.setIdentificador(usuario.getEntidad().getIdentificador());
        pedido.setNombre(usuario.getEntidad().getNombre());
        pedido.setApellido(usuario.getEntidad().getApellido());
        pedido.setCorreo(usuario.getEntidad().getCorreo());
        pedido.setDireccion(usuario.getEntidad().getDireccion());
        pedido.setTelefono(usuario.getEntidad().getTelefono());

        Cliente cliente = (Cliente) clienteServicio.buscaIdCliente(usuario.getEntidad().getIdentificador());
        pedido.setFormaPago(cliente.getFormaPago());


        pedidoServicio.save(pedido);
        guardarPedidoDetalles(carritoCabecera,pedido);

        carritoCabecera.setSubtotal(0.0);
        carritoCabecera.setListaDetalle(new ArrayList<>());

        carritoCabeceraServicio.crearCarritoCabecera(carritoCabecera);
        carritoDetalleServicio.eliminarTodosLosProductosDelCarritoDetalle();
        return ResponseEntity.ok("pedido enviado");
    }


    @PostMapping("pedido/facturarAlguienMas")
    public  ResponseEntity<String> enviarPedidoAnombredeAlguienmas(HttpSession httpSession, @RequestBody FacturarAlguienMas facturarAlguienMas){

        Usuario usuario = (Usuario) httpSession.getAttribute("Usuario");
        Cliente cliente = (Cliente) clienteServicio.buscaIdCliente(usuario.getEntidad().getIdentificador());
        CarritoCabecera carritoCabecera= recuperarCarritoCabecera(usuario);
        Pedido pedido = new Pedido();
        PedidoDetalle pedidoDetalle = new PedidoDetalle();

        pedido.setUsuario(usuario);
        pedido.setEstado(EstadoPedido.RECIBIDO);
        pedido.setFormaPago(cliente.getFormaPago());
        pedido.setLatitud(0);
        pedido.setLongitud(0);
        pedido.setCostoEnvio(0);
        pedido.setTiempoEspera(null);

        pedido.setIdentificador(facturarAlguienMas.getIdentificador());
        pedido.setNombre(facturarAlguienMas.getNombre());
        pedido.setApellido(facturarAlguienMas.getApellido());
        pedido.setCorreo(facturarAlguienMas.getCorreo());
        pedido.setDireccion(facturarAlguienMas.getDireccion());
        pedido.setTelefono(facturarAlguienMas.getTelefono());

        pedido.setTotal(carritoCabecera.getSubtotal());

        pedido.setFormaPago(cliente.getFormaPago());


        pedidoServicio.save(pedido);
        guardarPedidoDetalles(carritoCabecera,pedido);

        carritoCabecera.setSubtotal(0.0);
        carritoCabecera.setListaDetalle(new ArrayList<>());

        carritoCabeceraServicio.crearCarritoCabecera(carritoCabecera);
        carritoDetalleServicio.eliminarTodosLosProductosDelCarritoDetalle();
        return ResponseEntity.ok("pedido enviado");
    }


    public void guardarPedidoDetalles(CarritoCabecera carritoCabecera, Pedido pedido){

        for (CarritoDetalle carritoDetalle: carritoCabecera.getListaDetalle()

             ) {
            PedidoDetalle pedidoDetalle = new PedidoDetalle();
            pedidoDetalle.setCantidad(carritoDetalle.getCantidad());
            pedidoDetalle.setPrecio(carritoDetalle.getPrecio());
            pedidoDetalle.setSubtotal(carritoDetalle.getSubtotal());
            pedidoDetalle.setProductoSucursal(carritoDetalle.getProductoSucursal());
            pedidoDetalle.setPedido(pedido);
            pedidoDetalleServicio.save(pedidoDetalle);



        }
    }

    public CarritoCabecera recuperarCarritoCabecera(Usuario usuario){

        List<CarritoCabecera> carritoCabeceras = carritoCabeceraServicio.findAll();


        for (CarritoCabecera  carritoCabecera1: carritoCabeceras
        ) {
            if(carritoCabecera1.getUsuario().equals(usuario)){
                return  carritoCabecera1;
            }
        }
        return null;
    }

    @PutMapping("/pedido/update")
    public ResponseEntity<Pedido> updatePedido(@RequestBody ActualizarPedido actualizarPedido) {
        Optional<Pedido> pedidoOptional = pedidoServicio.findById(actualizarPedido.getId());
        if (pedidoOptional.isEmpty()) {
            Pedido pedido = pedidoOptional.orElseThrow(PedidoNoEncontradoException::new);
            return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
        }
        Optional<Usuario> usuarioOptional = usuarioServicio.findId(actualizarPedido.getUsuario());
        Optional<FormaPago> formaPagoOptional = formaPagoServicio.findById(actualizarPedido.getFormaPago());
        Pedido pedidoEncontrado = pedidoOptional.get();
        pedidoEncontrado.setUsuario(usuarioOptional.get());
        pedidoEncontrado.setLatitud(actualizarPedido.getLatitud());
        pedidoEncontrado.setLongitud(actualizarPedido.getLongitud());
        pedidoEncontrado.setEstado(actualizarPedido.getEstado());
        pedidoEncontrado.setTiempoEspera(actualizarPedido.getTiempoEspera());
        pedidoEncontrado.setCostoEnvio(actualizarPedido.getCostoEnvio());
      //  pedidoEncontrado.setDetalles(actualizarPedido.getDetalles());
        pedidoEncontrado.setFormaPago(formaPagoOptional.get());
        pedidoServicio.save(pedidoEncontrado);
        return ResponseEntity.ok(pedidoEncontrado);
    }

    @DeleteMapping("/pedido/delete/{id}")
    public ResponseEntity<String> deletePedido(@PathVariable int id) {
        pedidoServicio.delete(id);
        return ResponseEntity.ok("Pedido eliminado correctamente");
    }


    @GetMapping("pedido/listarPedidos")
    public  ResponseEntity<List<Pedido>> listarPedidos(HttpSession httpSession){

        Usuario usuario = (Usuario) httpSession.getAttribute("Usuario");

        List<Pedido> pedidos = pedidoServicio.findAll();
        List<Pedido> pedididosDeMiUsuario= new ArrayList<>();

        for (Pedido pedido: pedidos
             ) {
             if (pedido.getUsuario().equals(usuario)){
                pedididosDeMiUsuario.add(pedido);
}
        }

        return ResponseEntity.ok(pedididosDeMiUsuario);
    }


    @GetMapping("pedido/listarPedidoActual")
    public  ResponseEntity<Pedido> verpedidoActual(HttpSession httpSession){

        Usuario usuario = (Usuario) httpSession.getAttribute("Usuario");

        List<Pedido> pedidos = pedidoServicio.findAll();
        List<Pedido> pedididosDeMiUsuario= new ArrayList<>();
        Pedido pedido = new Pedido();

        for (Pedido pedido1: pedidos
        ) {
            pedido= pedido1;
        }

        return ResponseEntity.ok(pedido);
    }



}
