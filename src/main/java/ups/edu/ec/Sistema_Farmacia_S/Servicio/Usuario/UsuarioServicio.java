package ups.edu.ec.Sistema_Farmacia_S.Servicio.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Usuario;
import ups.edu.ec.Sistema_Farmacia_S.Repositorio.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepositorio.findAll();
    }

    public Optional findId(int codigo) {
        return (Optional) usuarioRepositorio.findById(codigo);
    }

    public void Crear(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    public void Eliminar(int codigo) {
        usuarioRepositorio.deleteById(codigo);
    }

    public Usuario EncontrarUsuario(String usuario, String contrasenia){
         return usuarioRepositorio.findUsuario(usuario,contrasenia);
    }
    public Usuario EncontrarUsuarioUser(String usuario){
        return usuarioRepositorio.findUsuarioUser(usuario);
    }

}
