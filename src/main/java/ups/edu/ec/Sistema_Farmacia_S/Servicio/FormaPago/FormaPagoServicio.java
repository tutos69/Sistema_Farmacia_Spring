package ups.edu.ec.Sistema_Farmacia_S.Servicio.FormaPago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.FormaPago;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.FormaPagoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagoServicio {

    @Autowired
    private FormaPagoRepositorio formaPagoRepositorio;

    public List<FormaPago> findAll(){
        return (List<FormaPago>) formaPagoRepositorio.findAll();
    }
    public Optional<FormaPago> findById(int id){
        return (Optional<FormaPago>) formaPagoRepositorio.findById(id);
    }
//    public Optional findById(int id){
//        return (Optional) formaPagoRepositorio.findById(id);
//   }

    public void save(FormaPago formaPago){
        formaPagoRepositorio.save(formaPago);
    }
    public void delete(int id){
        formaPagoRepositorio.deleteById(id);
    }

}
