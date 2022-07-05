package ups.edu.ec.Sistema_Farmacia_S.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.FormaPago;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Pedido;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.FormaPago.ActualizarFormaPago;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.FormaPago.CrearFormaPago;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Peticiones.Pedido.ActualizarPedido;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.FormaPagoRepositorio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.FormaPago.FormaPagoNoEncontradoException;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.FormaPago.FormaPagoServicio;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Pedido.PedidoNoEncontradoException;

import java.util.List;
import java.util.Optional;

@RestController //notacion de Spring
public class FormaPagoControlador {

    private FormaPagoServicio formaPagoServicio;

    @Autowired
    public void setFormaPagoServicio(FormaPagoServicio formaPagoServicio) {
        this.formaPagoServicio = formaPagoServicio;
    }

    @GetMapping("/formasDePago") //obtener el listado de Formas de Pago
    public ResponseEntity<List<FormaPago>> getAllFormaPagos() {
        List<FormaPago> listaFormasPago = formaPagoServicio.findAll();
        return new ResponseEntity<List<FormaPago>>(listaFormasPago, HttpStatus.OK);
    }

    @PostMapping("/formaPago/create") //Crear Forma De Pago
    public ResponseEntity<FormaPago> createFormaPago(@RequestBody CrearFormaPago crearFormaPago) {
        FormaPago formaPago = new FormaPago();
        formaPago.setTipoPago(crearFormaPago.getTipoPago());
        formaPago.setMeses(crearFormaPago.getMeses());
        formaPago.setVuelto(crearFormaPago.getVuelto());
        formaPago.setNombreTitular(crearFormaPago.getNombreTitular());
        formaPago.setNumeroTarjeta(crearFormaPago.getNumeroTarjeta());
        formaPagoServicio.save(formaPago);
        return ResponseEntity.ok(formaPago);
    }

    @PutMapping("/formaPago/update")
    public ResponseEntity<FormaPago> updateFormaPago(@RequestBody ActualizarFormaPago actualizarFormaPago) {
        Optional<FormaPago> formaPagoOptional = formaPagoServicio.findById(actualizarFormaPago.getId());
        if (formaPagoOptional.isEmpty()) {
            FormaPago formaPago = formaPagoOptional.orElseThrow(FormaPagoNoEncontradoException::new);
            return new ResponseEntity<FormaPago>(formaPago, HttpStatus.OK);
        }
        FormaPago formaPagoEncontrada = formaPagoOptional.get();
        formaPagoEncontrada.setTipoPago(actualizarFormaPago.getTipoPago());
        formaPagoEncontrada.setMeses(actualizarFormaPago.getMeses());
        formaPagoEncontrada.setVuelto(actualizarFormaPago.getVuelto());
        formaPagoEncontrada.setNombreTitular(actualizarFormaPago.getNombreTitular());
        formaPagoEncontrada.setNumeroTarjeta(actualizarFormaPago.getNumeroTarjeta());
        formaPagoServicio.save(formaPagoEncontrada);
        return ResponseEntity.ok(formaPagoEncontrada);
    }

    @DeleteMapping("/formaPago/delete/{id}")
    public ResponseEntity<String> deleteFormaPago(@PathVariable int id) {
        formaPagoServicio.delete(id);
        return ResponseEntity.ok("Forma de Pago  eliminada correctamente");
    }
}
