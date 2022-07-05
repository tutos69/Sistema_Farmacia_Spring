package ups.edu.ec.Sistema_Farmacia_S.Controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.CarritoCabecera;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Usuario.CrearUsuario;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Usuario.ModificarUsuario;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Usuario.RecuperarUsuario;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Producto;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Usuario;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.CarritoCabecera.CarritoCabeceraServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Cliente.ClienteServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Usuario.UsuarioServicio;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioControlador {


    //public Usuario usuario;
    private UsuarioServicio usuarioServicio;
    private ClienteServicio clienteServicio;

    private CarritoCabeceraServicio carritoCabeceraServicio;
    @Autowired
    public void setUsuarioServicio (UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @Autowired
    public void setClienteServicio(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }
    @Autowired
    public void setCarritoCabeceraServicio(CarritoCabeceraServicio carritoCabeceraServicio) {
        this.carritoCabeceraServicio = carritoCabeceraServicio;
    }




    @PostMapping("usuario/create")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody CrearUsuario crearUsuario) {

        Optional<Cliente> cliente = Optional.ofNullable(clienteServicio.buscaIdCliente(crearUsuario.getCedula()));
        System.out.printf(String.valueOf(cliente.get()));
        if (cliente.isEmpty()) {
            System.out.println("Cliente no encontrado");
            return ResponseEntity.badRequest().build();
        }
        Usuario usuario = new Usuario();
        usuario.setUsuario(crearUsuario.getUsuario());
        usuario.setContrasenia(crearUsuario.getContrasenia());
        usuario.setRol("CLIENTE");
        usuario.setEntidad(cliente.get());

        CarritoCabecera carritoCabecera = new CarritoCabecera();
        carritoCabecera.setUsuario(usuario);
        carritoCabecera.setSubtotal(0.0);

        usuarioServicio.Crear(usuario);
        carritoCabeceraServicio.crearCarritoCabecera(carritoCabecera);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/usuario/eliminar/{codigo}")
    public ResponseEntity<String> deliteUsuario(@PathVariable int codigo) {
        usuarioServicio.Eliminar(codigo);
        return ResponseEntity.ok("Usuario Eliminado");
    }


    @PostMapping("usuario/iniciarSesion")
    public ResponseEntity<Usuario> iniciarSesion(@RequestBody RecuperarUsuario recuperarUsuario, HttpSession httpSession) {


        Usuario usuario= new Usuario();
        usuario= usuarioServicio.EncontrarUsuario(recuperarUsuario.getUsuario(), recuperarUsuario.getContrasenia());
      //  this.usuario=usuario;
        httpSession.setAttribute("Usuario",usuario);
        return ResponseEntity.ok(usuario);
    }




    @PutMapping("/usuario/modificar")
    public ResponseEntity<String> updateUsuario(@RequestBody ModificarUsuario modificarUsuario) {

        Optional<Usuario> Datos = usuarioServicio.findId(modificarUsuario.getId());
        if (Datos.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Usuario usuario = Datos.get();
        usuario.setUsuario(modificarUsuario.getUsuario());
        usuario.setContrasenia(modificarUsuario.getContrasenia());
        usuarioServicio.Crear(usuario);
        return ResponseEntity.ok("Cliente Actualizado");
    }


   // public Usuario getUsuario() {
     //   return usuario;
   // }
   // @Autowired
    //public void setUsuario(Usuario usuario) {
      //  this.usuario = usuario;
    //}
}
