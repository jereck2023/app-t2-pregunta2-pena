package pe.edu.cibertec.app_pregunta2_pena.service.implementaciones;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.app_pregunta2_pena.model.Usuario;
import pe.edu.cibertec.app_pregunta2_pena.repository.UsuarioRepository;
import pe.edu.cibertec.app_pregunta2_pena.service.IUsuarioService;

@RequiredArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    @Override
    public Usuario obtenerUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }
}
