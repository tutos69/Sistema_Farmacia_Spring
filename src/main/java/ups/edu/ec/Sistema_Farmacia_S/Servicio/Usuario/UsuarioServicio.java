package ups.edu.ec.Sistema_Farmacia_S.Servicio.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Usuario;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    public List<Usuario> findAll(){
        return (List<Usuario>) usuarioRepositorio.findAll();
    }

    public Optional findId(Long codigo){
        return (Optional)usuarioRepositorio.findById(codigo);
    }

    public void Crear(Usuario usuario){
        usuarioRepositorio.save(usuario);
    }

    public void Eliminar(Long cosigo) {
        usuarioRepositorio.deleteById(cosigo);
    }
}
