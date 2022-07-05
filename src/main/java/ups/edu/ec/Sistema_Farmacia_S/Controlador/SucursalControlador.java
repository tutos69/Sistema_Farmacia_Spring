package ups.edu.ec.Sistema_Farmacia_S.Controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Sucursal;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Producto.ProductoServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Sucursal.SucursalServicio;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class SucursalControlador {


    private SucursalServicio sucursalServicio;


    @Autowired //inyeccion de dependencia
    public void setSucursalServicio(SucursalServicio sucursalServicio) {
        this.sucursalServicio = sucursalServicio;
    }




    @GetMapping("escogerSucursal/{nombreClave}") //obtener el listado de Pedidos
    public ResponseEntity<Sucursal> escogerSucursal(@PathVariable String nombreClave, HttpSession httpSession) {


        Sucursal s = null;
        List<Sucursal> sucursals = sucursalServicio.findAll();
        for (Sucursal sucursal: sucursals
             ) {
            if(sucursal.getNombreClave().equals(nombreClave)){
                s=sucursal;
                System.out.println(sucursal);
            }

        }
        httpSession.setAttribute("Sucursal",s);
        return new ResponseEntity<Sucursal>(s, HttpStatus.OK);
    }
}
