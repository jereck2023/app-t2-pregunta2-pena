package pe.edu.cibertec.app_pregunta2_pena.service;

import pe.edu.cibertec.app_pregunta2_pena.model.Pelicula;

import java.util.List;
import java.util.Optional;

public interface IPeliculaService {

    List<Pelicula> listarPeliculas();
    Pelicula registraPelicula(Pelicula pelicula);
    Optional<Pelicula> obtenerPeliculaPorId(Integer id);
    Pelicula editarPelicula(Integer id, Pelicula pelicula);
}
