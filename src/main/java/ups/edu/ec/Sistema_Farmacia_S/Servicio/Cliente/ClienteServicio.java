package ups.edu.ec.Sistema_Farmacia_S.Servicio.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.ClienteRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> findAll(){
        return (List<Cliente>) clienteRepositorio.findAll();
    }

    public Optional findId(Long codigo){
        return (Optional)clienteRepositorio.findById(codigo);
    }

    public void Crear(Cliente cliente){
        clienteRepositorio.save(cliente);
    }

    public List<String> Nombres(){
        return clienteRepositorio.finallNombres();
    }


    public void Eliminar(Long cosigo) {
        clienteRepositorio.deleteById(cosigo);
    }
}
