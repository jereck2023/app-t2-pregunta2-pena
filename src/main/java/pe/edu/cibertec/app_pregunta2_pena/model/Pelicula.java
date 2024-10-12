package pe.edu.cibertec.app_pregunta2_pena.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpelicula;
    private String nombre;
    private String descripcion;
    private Integer duracion;
}
