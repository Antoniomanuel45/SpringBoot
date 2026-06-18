package com.inserta.crudalumnos.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inserta.crudalumnos.modelo.Alumno;
import com.inserta.crudalumnos.repositorio.AlumnoRepository;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//Para la Api/Rest (en el controlador)se pone la anotacion @Restcontroller
// @ResquestMapping define el endpoint (la url que sale en swagger/postman) 
@RestController
@RequestMapping("/api/alumnos")

public class AlumnoController {
    //Agregamos el repo
    private final AlumnoRepository alumnoRepo;

     //Constructor del Repo
    public AlumnoController(AlumnoRepository alumnoRepo) {
        this.alumnoRepo = alumnoRepo;
    }

    //Por cada endpoint se crea un metodo
    //endpoint -> http://localhost:8080/api/alumnos/consultar
    //añadimos Swagger Control + MAY + p
    //spring initializr:add Starter > Springdoc open Api web
    //se añade el paquete [proceed] y se añade al Paht
    //En la application.properties se añade la url.path de swagger 
    // http://localhost:8080/swagger-ui/index.html
    @GetMapping("/consultar")
    @Operation(summary = "Lista alumnos")
    public List <Alumno> verAlumnos(){
        return alumnoRepo.findAll();
    }


    
    
    
    

   

}
