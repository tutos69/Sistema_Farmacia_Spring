package ups.edu.ec.Sistema_Farmacia_S.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.*;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.CarritoDetalle.CrearCarritoDetalle;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Usuario.RecuperarUsuario;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.CarritoCabecera.CarritoCabeceraServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.CarritoDetalle.CarritoDetalleServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.ProductoSucursal.ProductoSucursalServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Usuario.UsuarioServicio;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CarritoDetalleControlador

{

    private CarritoDetalleServicio carritoDetalleServicio;

    private CarritoCabeceraServicio carritoCabeceraServicio;
    private ProductoSucursalServicio productoSucursalServicio;

    private UsuarioServicio usuarioServicio;

    @Autowired
    public void setCarritoDetalleServicio(CarritoDetalleServicio carritoDetalleServicio) {
        this.carritoDetalleServicio = carritoDetalleServicio;
    }
    @Autowired
    public void setCarritoCabeceraServicio(CarritoCabeceraServicio carritoCabeceraServicio) {
        this.carritoCabeceraServicio = carritoCabeceraServicio;
    }



    @Autowired
    public void setProductoSucursalServicio(ProductoSucursalServicio productoSucursalServicio) {
        this.productoSucursalServicio = productoSucursalServicio;
    }
    @Autowired
    public void setUsuarioServicio(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }



    @PostMapping("carrito/agregarProducto")
    public ResponseEntity<String> agregarProductoAlCarritoDetalle(@RequestBody CrearCarritoDetalle crearCarritoDetalle, HttpSession httpSession) {

        CarritoDetalle carritoDetalle= new CarritoDetalle();
        Usuario usuario = (Usuario) httpSession.getAttribute("Usuario");
        CarritoCabecera carritoCabecera= recuperarCarritoCabecera(usuario);
        ProductoSucursal productoSucursal= recuperarProducto(crearCarritoDetalle.getNombreProductoSucursal(),httpSession);
        System.out.println(productoSucursal);
        carritoDetalle.setCantidad(crearCarritoDetalle.getCantidad());
        carritoDetalle.setProductoSucursal(productoSucursal);
        carritoDetalle.setPrecio(productoSucursal.getProducto().getPrecio());
        carritoDetalle.setSubtotal(productoSucursal.getProducto().getPrecio()*crearCarritoDetalle.getCantidad());
        carritoDetalle.setCarritoCabecera(carritoCabecera);
        carritoDetalleServicio.agregarProductoAlCarritoDetalle(carritoDetalle);
        carritoCabecera.setSubtotal(carritoCabecera.getSubtotal()+carritoDetalle.getSubtotal());
        carritoCabeceraServicio.crearCarritoCabecera(carritoCabecera);
        String mensaje = "producto agregado, su nuevo total a pagar es :" + String.valueOf(carritoCabecera.getSubtotal());
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("carrito/listarCarrita")
    public ResponseEntity<CarritoCabecera> listarCarrito(HttpSession httpSession){
        Usuario usuario = (Usuario) httpSession.getAttribute("Usuario");

        return ResponseEntity.ok(recuperarCarritoCabecera(usuario));

    }

    public ProductoSucursal recuperarProducto(String nombreProducto, HttpSession httpSession){

        Sucursal sucursal = (Sucursal) httpSession.getAttribute("Sucursal");

        List<ProductoSucursal> listaProducto = productoSucursalServicio.findAll();
        for (ProductoSucursal productoSucursal: listaProducto
        ) {
            System.out.println(productoSucursal);
            if(productoSucursal.getSucursal().equals(sucursal) && productoSucursal.getProducto().getNombre().equals(nombreProducto)){
                return productoSucursal;
            }
        }

        return  null;


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
}
