import java.util.List;
import java.util.ArrayList;

public class Loja {
    List<Usuario> usuarios = new ArrayList<Usuario>();

    public boolean verificarUsuarioExist (String email) {
        for (Usuario user : usuarios) if (user.getEmail().Equals(email)) return false;
        return true;
    }

    public void cadastrarUsuario (Usuario usuario) {
        if (!verificarUsuarioExist(usuario.getEmail())) return;
        usuarios.add(usuario);
    }
}
