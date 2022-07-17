package ups.edu.ec.Sistema_Farmacia_S.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Producto;
import ups.edu.ec.Sistema_Farmacia_S.Modelo.Usuario;

import java.util.List;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

    @Query("select u from Usuario u ")
    List<Usuario> finallCategoriaProducto();


    @Query("select u from Usuario u where u.usuario=:usuario and u.contrasenia=:contrasenia ")
    Usuario findUsuario(String usuario, String contrasenia);

    @Query("select u from Usuario u where u.usuario=:usuario")
    Usuario findUsuarioUser(String usuario);
}
