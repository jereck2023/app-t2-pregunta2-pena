package pe.edu.cibertec.app_pregunta2_pena.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.app_pregunta2_pena.model.Pelicula;
import pe.edu.cibertec.app_pregunta2_pena.service.implementaciones.PeliculaService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/pelicula")
public class PeliculaController {

    private final PeliculaService peliculaService;

    @PreAuthorize("hasRole('COORDINADOR')")
    @GetMapping
    public List<Pelicula> listarPeliculas() {
        return peliculaService.listarPeliculas();
    }

    @PreAuthorize("hasRole('COORDINADOR')AND hasRole('GESTOR')")
    // GET: Obtener una película por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> obtenerPeliculaPorId(@PathVariable Integer id) {
        Optional<Pelicula> pelicula = peliculaService.obtenerPeliculaPorId(id);
        if (pelicula.isPresent()) {
            return ResponseEntity.ok(pelicula.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST: Registrar una nueva película
    @PreAuthorize("hasRole('GESTOR')")
    @PostMapping
    public Pelicula registrarPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.registraPelicula(pelicula);
    }

    // PUT: Editar una película existente
    @PreAuthorize("hasAnyRole('COORDINADOR','GESTOR')")
    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> editarPelicula(@PathVariable Integer id, @RequestBody Pelicula detallesPelicula) {
        Pelicula peliculaEditada = peliculaService.editarPelicula(id, detallesPelicula);
        if (peliculaEditada != null) {
            return ResponseEntity.ok(peliculaEditada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
