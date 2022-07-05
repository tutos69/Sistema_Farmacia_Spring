package ups.edu.ec.Sistema_Farmacia_S.Servicio.Sucursal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Producto;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Sucursal;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.SucursalRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServicio {

    @Autowired
    private SucursalRepositorio sucursalRepositorio;

    public List<Sucursal> findAll() {
        return (List<Sucursal>) sucursalRepositorio.findAll();
    }

    public Sucursal recuperarSucursal(String nombreClave){
        return  sucursalRepositorio.recuperarSucursal(nombreClave);
    }





}
