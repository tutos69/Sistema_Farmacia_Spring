package ups.edu.ec.Sistema_Farmacia_S.Servicio.Detalle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Detalle;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.ClienteRepositorio;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.DetalleRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleServicio {
    @Autowired
    private DetalleRepositorio detalleRepositorio;

    public List<Detalle> findAll(){
        return (List<Detalle>) detalleRepositorio.findAll();
    }

    public Optional findId(int codigo){
        return (Optional)detalleRepositorio.findById(codigo);
    }

    public void Crear(Detalle detalle){
        detalleRepositorio.save(detalle);
    }


    public void Eliminar(int codigo) {
        detalleRepositorio.deleteById(codigo);
    }
}
