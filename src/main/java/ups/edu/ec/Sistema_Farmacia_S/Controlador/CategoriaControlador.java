package ups.edu.ec.Sistema_Farmacia_S.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Categoria;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;
import ups.edu.ec.Sistema_Farmacia_S.Servicio.Categoria.CategoriaServicio;

import java.util.List;

@RestController
public class CategoriaControlador {
    private CategoriaServicio categoriaServicio;
    @Autowired
    public void setCategoriaServicio(CategoriaServicio categoriaServicio) {
        this.categoriaServicio = categoriaServicio;
    }

    @GetMapping("/categoria")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Categoria>> getAllCategoria() {
        List<Categoria> listCategoria = categoriaServicio.findAll();
        return new ResponseEntity<List<Categoria>>(listCategoria, HttpStatus.OK);
    }
}
