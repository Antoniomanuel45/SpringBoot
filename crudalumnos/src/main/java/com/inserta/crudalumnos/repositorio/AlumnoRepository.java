package com.inserta.crudalumnos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import com.inserta.crudalumnos.modelo.Alumno;
/**
 * JpaRepository <Alumno,String>
 * Alumno es el modelo y el String es el tipo de la PK (nif)
 */

public interface AlumnoRepository extends JpaRepository <Alumno,String>{
=======
import com.inserta.crudalumnos.modelo.Alumno;
/**
 * JpaRepository<Alumno,String> 
 * Alumno es el modelo y el String es el tipo de la PK (nif)
 */

public interface AlumnoRepository extends JpaRepository<Alumno,String> {
>>>>>>> 5206bdef49cc2cceea7014c42d8cf141d5d861c9
    
}
