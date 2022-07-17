package ups.edu.ec.Sistema_Farmacia_S.Servicio.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Categoria;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Cliente;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.CategoriaRepositorio;

import java.util.List;

@Service
public class CategoriaServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaRepositorio.findAll();
    }
}
