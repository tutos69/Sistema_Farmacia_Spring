package ups.edu.ec.Sistema_Farmacia_S.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Cliente.CrearCliente;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Cliente.ModificarCliente;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Cliente.ClienteServicio;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteControlador {

    private ClienteServicio clienteServicio;

    @Autowired
    public void setClienteRepositorio(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @PostMapping("/cliente/create")
    public ResponseEntity<Cliente> createPersona(@RequestBody CrearCliente crearCliente) {
        Cliente cliente = new Cliente();
        cliente.setIdentificador(crearCliente.getIdentificador());
        cliente.setApellido(crearCliente.getApellido());
        cliente.setFechaNacimiento(crearCliente.getFechaNacimiento());
        cliente.setNombre(crearCliente.getNombre());
        cliente.setCorreo(crearCliente.getCorreo());
        cliente.setTelefono(crearCliente.getTelefono());
        cliente.setDireccion(crearCliente.getDireccion());

        clienteServicio.Crear(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> getAllPersonas() {
        List<Cliente> personaList = clienteServicio.findAll();
        return new ResponseEntity<List<Cliente>>(personaList, HttpStatus.OK);
    }

    @DeleteMapping("/cliente/eliminar/{codigo}")
    public ResponseEntity<String> delitePersona(@PathVariable int codigo) {

        clienteServicio.Eliminar(codigo);
        return ResponseEntity.ok("Cliente Eliminado");
    }

    @PutMapping("/cliente/modificar")
    public ResponseEntity<String> updatePersona(@RequestBody ModificarCliente modificarCliente) {

        Optional<Cliente> Datos = clienteServicio.findId(modificarCliente.getId());
        if (Datos.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Cliente cliente = Datos.get();
        cliente.setApellido(modificarCliente.getApellido());
        cliente.setFechaNacimiento(modificarCliente.getFechaNacimiento());
        cliente.setNombre(modificarCliente.getNombre());
        cliente.setCorreo(modificarCliente.getCorreo());
        cliente.setTelefono(modificarCliente.getTelefono());
        cliente.setDireccion(modificarCliente.getDireccion());
        clienteServicio.Crear(cliente);
        return ResponseEntity.ok("Cliente Actualizado");
    }


}
