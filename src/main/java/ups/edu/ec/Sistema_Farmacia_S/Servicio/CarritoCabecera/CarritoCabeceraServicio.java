package ups.edu.ec.Sistema_Farmacia_S.Servicio.CarritoCabecera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.CarritoCabecera;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.CarritoDetalle;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.CarritoCabeceraRepositorio;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.ClienteRepositorio;

import java.util.List;
@Service
public class CarritoCabeceraServicio {

    @Autowired
    private CarritoCabeceraRepositorio carritoCabeceraRepositorio;

    public List<CarritoCabecera> findAll() {
        return (List<CarritoCabecera>) carritoCabeceraRepositorio.findAll();
    }

    public void crearCarritoCabecera(CarritoCabecera carritoCabecera){
        carritoCabeceraRepositorio.save(carritoCabecera);
    }
}
