package com.inserta.crudalumnos.controlador;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inserta.crudalumnos.modelo.Alumno;
import com.inserta.crudalumnos.modelo.Asignatura;
import com.inserta.crudalumnos.repositorio.AlumnoRepository;
import com.inserta.crudalumnos.repositorio.AsignaturaRepository;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//Para la Api/Rest (en el controlador)se pone la anotacion @Restcontroller
// @ResquestMapping define el endpoint (la url que sale en swagger/postman) 
@RestController
@RequestMapping("/api/asignaturas")

public class AsignaturaController {
    //Agregamos el repo
    private final AsignaturaRepository asignaturaRepo;

     //Constructor del Repo
    public AsignaturaController(AsignaturaRepository asignaturaRepo) {
        this.asignaturaRepo = asignaturaRepo;
    }

    
    @GetMapping("/consultar")
    @Operation(summary = "Lista asignaturas")
    public List <Asignatura> verAsignaturas(){
        return asignaturaRepo.findAll();
    }



}
