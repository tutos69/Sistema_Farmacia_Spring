package ups.edu.ec.Sistema_Farmacia_S.Servicio.CarritoDetalle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.CarritoCabecera;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.CarritoDetalle;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.CarritoCabeceraRepositorio;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.CarritoDetalleRepositorio;

import java.util.List;

@Service
public class CarritoDetalleServicio {

    @Autowired
    private CarritoDetalleRepositorio carritoDetalleRepositorio;

    public List<CarritoDetalle> findAll() {
        return (List<CarritoDetalle>) carritoDetalleRepositorio.findAll();
    }

    public void agregarProductoAlCarritoDetalle(CarritoDetalle carritoDetalle){
        carritoDetalleRepositorio.save(carritoDetalle);
    }

    public void eliminarProductoAlCarritoDetalle(CarritoDetalle carritoDetalle){
        carritoDetalleRepositorio.delete(carritoDetalle);
    }

    public void eliminarTodosLosProductosDelCarritoDetalle(){
        carritoDetalleRepositorio.deleteAll();
    }
}
