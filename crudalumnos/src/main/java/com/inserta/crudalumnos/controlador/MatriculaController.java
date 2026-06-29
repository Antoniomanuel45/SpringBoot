package com.inserta.crudalumnos.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inserta.crudalumnos.modelo.Alumno;
import com.inserta.crudalumnos.modelo.AlumnoAsignatura;
import com.inserta.crudalumnos.modelo.Asignatura;
import com.inserta.crudalumnos.repositorio.AlumnoAsignaturaRepository;
import com.inserta.crudalumnos.repositorio.AlumnoRepository;
import com.inserta.crudalumnos.repositorio.AsignaturaRepository;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/alumnos-asignaturas")
public class MatriculaController {
    // Declaramos los repos y el contructor asociado
    private final AlumnoRepository alumnoRepo;
    private final AsignaturaRepository asignaturaRepo;
    private final AlumnoAsignaturaRepository alumnoAsignaturaRepo;

    public MatriculaController(
            AlumnoRepository alumnoRepo,
            AsignaturaRepository asignaturaRepo,
            AlumnoAsignaturaRepository alumnoAsignaturaRepo) {
        this.alumnoRepo = alumnoRepo;
        this.asignaturaRepo = asignaturaRepo;
        this.alumnoAsignaturaRepo = alumnoAsignaturaRepo;
    }

    // POST - C01 Matricula un alumno en una asignatura
    // ResponseEntity <?> puede ser de varios tipos ->? significa generico
    // Permite:
    // a) ReponseEntity.notFound()
    // b) ResponsEntity.badResquest()
    // c) ResponseEntity.ok()
    @PostMapping("/matricular/{nif}/{idAsignatura}")
    @Operation(summary = "Matricula un alumno en una asignatura")
    public ResponseEntity<?> matricular(
            @PathVariable String nif, @PathVariable Integer idAsignatura) {

        // 1. Comprobamos que existe el alumno y la asignatura
        final Alumno alumno = alumnoRepo.findById(nif).orElse(null);
        if (alumno == null) {
            //return ResponseEntity.notFound().build(); // Error 404
            return ResponseEntity.status(HttpStatus. NOT_FOUND)
            .body("Alumno no encontrado");

        
        }


        final Asignatura asignatura = asignaturaRepo.findById(idAsignatura).orElse(null);

        // 2. Comprobamos que Ya no esta matriculado en esa asignatura
        boolean yaEstaMatriculado = alumnoAsignaturaRepo.existeMatricula(nif, idAsignatura);
        if (yaEstaMatriculado == true) {
            //return ResponseEntity.badRequest().body("Ya matriculado");

             return ResponseEntity.status(HttpStatus. NOT_FOUND)
            .body("Asignatura no encontrada");
        }
        //Si esta todo correcto,entonces MATRICULO!
        AlumnoAsignatura matricula = new AlumnoAsignatura(null, alumno, asignatura);
        return ResponseEntity.ok(alumnoAsignaturaRepo.save(matricula));
    }

@PostMapping("/desmatricular/{nif}/{idAsignatura}")
    @Operation(summary = "DesMatricula un alumno en una asignatura")
    public ResponseEntity<?> desmatricular(
            @PathVariable String nif, @PathVariable Integer idAsignatura) {

        // 1. Comprobamos que Ya no esta matriculado en esa asignatura
        if (!alumnoAsignaturaRepo.existeMatricula(nif, idAsignatura)) {
            //return ResponseEntity.badRequest().body("Ya matriculado");

            return ResponseEntity.notFound().build();
        }

        // Vale, la matricula. Ahora toca borrar

    }

}
