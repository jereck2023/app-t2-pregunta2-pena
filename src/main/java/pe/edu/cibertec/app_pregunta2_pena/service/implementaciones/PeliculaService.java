package pe.edu.cibertec.app_pregunta2_pena.service.implementaciones;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.app_pregunta2_pena.model.Pelicula;
import pe.edu.cibertec.app_pregunta2_pena.repository.PeliculaRepository;
import pe.edu.cibertec.app_pregunta2_pena.service.IPeliculaService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PeliculaService implements IPeliculaService {

    private final PeliculaRepository peliculaRepository;
    @Override
    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula registraPelicula(Pelicula pelicula) {
            peliculaRepository.save(pelicula);
        return pelicula;
    }

    @Override
    public Optional<Pelicula> obtenerPeliculaPorId(Integer id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public Pelicula editarPelicula(Integer id, Pelicula pelicula) {
        Optional<Pelicula> list = peliculaRepository.findById(id);
        Pelicula peliculaExistente = list.get();
        peliculaExistente.setNombre(pelicula.getNombre());
        peliculaExistente.setDescripcion(pelicula.getDescripcion());
        peliculaExistente.setDuracion(pelicula.getDuracion());
        return peliculaRepository.save(peliculaExistente);
    }

}
