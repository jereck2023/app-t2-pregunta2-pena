package pe.edu.cibertec.app_pregunta2_pena.service.implementaciones;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.app_pregunta2_pena.model.Rol;
import pe.edu.cibertec.app_pregunta2_pena.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class DetalleService implements UserDetailsService {
    private final UsuarioService usuarioService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.obtenerUsuario(username);
        return crearUserDetails(usuario,
                rolesUsuario(usuario.getRoles()));
    }

    public List<GrantedAuthority> rolesUsuario(Set<Rol> roleslist){
        List<GrantedAuthority> roles = new ArrayList<>();
        for (Rol rol : roleslist){
            roles.add(new SimpleGrantedAuthority("ROLE_"+rol.getNombrerol()));
        }
        return  roles;
    }

    private UserDetails crearUserDetails(
            Usuario usuario, List<GrantedAuthority> authorityList
    ){
        return  new User(
                usuario.getUsuario(),
                usuario.getPassword(),
                usuario.getActivo(),
                true,
                true,
                true,
                authorityList);
    }
}
