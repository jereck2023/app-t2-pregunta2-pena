package pe.edu.cibertec.app_pregunta2_pena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.app_pregunta2_pena.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
