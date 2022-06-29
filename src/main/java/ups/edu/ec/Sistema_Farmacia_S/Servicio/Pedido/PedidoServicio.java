package ups.edu.ec.Sistema_Farmacia_S.Servicio.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Pedido;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.PedidoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {
    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public List<Pedido> findAll(){
        return (List<Pedido>) pedidoRepositorio.findAll();
    }
    public Optional<Pedido> findById(int id){
        return (Optional<Pedido>) pedidoRepositorio.findById(id);
    }

    public void save(Pedido pedido){
        pedidoRepositorio.save(pedido);
    }


    public void delete(int id){
        pedidoRepositorio.deleteById(id);
    }






}
