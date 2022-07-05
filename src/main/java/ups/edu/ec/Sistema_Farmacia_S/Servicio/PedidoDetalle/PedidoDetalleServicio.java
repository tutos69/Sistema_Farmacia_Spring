package ups.edu.ec.Sistema_Farmacia_S.Servicio.PedidoDetalle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Pedido;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.PedidoDetalle;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.ClienteRepositorio;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.PedidoDetalleRepositorio;

import java.util.List;
@Service
public class PedidoDetalleServicio {

    @Autowired
    private PedidoDetalleRepositorio pedidoDetalleRepositorio;

    public List<PedidoDetalle> findAll() {
        return (List<PedidoDetalle>) pedidoDetalleRepositorio.findAll();
    }

    public void save(PedidoDetalle pedidoDetalle){

        pedidoDetalleRepositorio.save(pedidoDetalle);
    }
}
