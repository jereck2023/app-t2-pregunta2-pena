package pe.edu.cibertec.app_pregunta2_pena.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioResponseDto {
    private Integer id;
    private String usuario;
    private String token;
}
