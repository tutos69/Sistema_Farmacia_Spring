package ups.edu.ec.Sistema_Farmacia_S.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.CarritoCabecera;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Usuario;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.CarritoCabecera.CarritoCabeceraServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.CarritoDetalle.CarritoDetalleServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Cliente.ClienteServicio;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CarritoCabeceraControlador {

    private CarritoCabeceraServicio carritoCabeceraServicio;

    @Autowired
    public void setCarritoCabeceraServicio(CarritoCabeceraServicio carritoCabeceraServicio) {
        this.carritoCabeceraServicio = carritoCabeceraServicio;
    }


    @GetMapping("verCarrito")
    public ResponseEntity<CarritoCabecera> getCarrito(HttpSession httpSession) {
        CarritoCabecera carritoCabecera= new CarritoCabecera();
        Usuario usuario = (Usuario) httpSession.getAttribute("Usuario");
        List<CarritoCabecera> carritoCabeceras = carritoCabeceraServicio.findAll();
        for (CarritoCabecera carritoCabecera1 : carritoCabeceras
        ){
            if(usuario.equals(carritoCabecera1.getUsuario()));
            carritoCabecera=carritoCabecera1;

        }
        return new ResponseEntity<CarritoCabecera>(carritoCabecera, HttpStatus.OK);
    }
}
