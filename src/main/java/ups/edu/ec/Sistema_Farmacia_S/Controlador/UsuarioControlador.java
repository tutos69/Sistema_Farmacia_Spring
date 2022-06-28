package ups.edu.ec.Sistema_Farmacia_S.Controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Cliente.ModificarCliente;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Usuario.CrearUsuario;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Usuario.ModificarUsuario;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Usuario;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Cliente.ClienteServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Usuario.UsuarioServicio;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioControlador {
    private UsuarioServicio usuarioServicio;
    private ClienteServicio clienteServicio;

    @Autowired
    public void setUsuarioServicio(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @Autowired
    public void setClienteServicio(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @PostMapping("/usuario/create")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody CrearUsuario crearUsuario) {

        Optional <Cliente>  cliente = Optional.ofNullable(clienteServicio.buscaIdCliente(crearUsuario.getEntidad()));
        System.out.printf(String.valueOf(cliente.get()));
        if (cliente.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Usuario usuario = new Usuario();
        usuario.setUsuario(crearUsuario.getUsuario());
        usuario.setContrasenia(crearUsuario.getContrasenia());
        usuario.setRol("CLIENTE");
        usuario.setEntidad(cliente.get());
        usuarioServicio.Crear(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/usuario/eliminar/{codigo}")
    public  ResponseEntity<String> deliteUsuario(@PathVariable int codigo) {
        usuarioServicio.Eliminar(codigo);
        return ResponseEntity.ok("Usuario Eliminado");
    }


    @PutMapping("/usuario/modificar")
    public  ResponseEntity<String> updateUsuario(@RequestBody ModificarUsuario modificarUsuario) {

        Optional<Usuario> Datos= usuarioServicio.findId(modificarUsuario.getId());
        if (Datos.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Usuario usuario = Datos.get();
        usuario.setUsuario(modificarUsuario.getUsuario());
        usuario.setContrasenia(modificarUsuario.getContrasenia());
        usuarioServicio.Crear(usuario);
        return ResponseEntity.ok("Cliente Actualizado");
    }
}
