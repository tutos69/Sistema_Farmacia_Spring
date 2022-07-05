package ups.edu.ec.Sistema_Farmacia_S.Servicio.ProductoSucursal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.ProductoSucursal;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.ProductoRepositorio;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.ProductoSucursalRepositorio;

import java.util.List;
import java.util.Optional;


@Service
public class ProductoSucursalServicio {

    @Autowired
    private ProductoSucursalRepositorio productoSucursalRepositorio;

    public List<ProductoSucursal> findAll() {
        return (List<ProductoSucursal>) productoSucursalRepositorio.findAll();
    }



}
