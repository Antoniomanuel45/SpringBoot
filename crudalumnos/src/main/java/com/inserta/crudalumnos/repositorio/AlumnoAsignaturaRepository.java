package com.inserta.crudalumnos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.inserta.crudalumnos.modelo.AlumnoAsignatura;

import jakarta.transaction.Transactional;

// Añadimos la etiqueta @Repository (sobre todo si se va a añadir consultas manuales)
@Repository
public interface AlumnoAsignaturaRepository extends JpaRepository<AlumnoAsignatura, Long>{
    // Paso 1a. Definir el método abstracto de contar asignaturas por NIF
    @Transactional
    long countByAlumnoNif(String nif);

    // Paso 2a. Definir el método abstracto de borrado de asignaturas
    // Operaciones con la BBDD que implica tocar una tabla relacionada
    @Transactional
    void deleteByAlumnoNif(String nif);

    // Ver si un alumno (por nif) tiene asignaturas matriculadas
    /**
     * Verifica si existe una matrícula de un alumno en una asignatura concreta
     * @Query(""" """)              → Anotación de Query desde v15 de Java
     * FROM AlumnoAsignatura aa     → Alias de Tabla
     * @param nif                   → nif del alumno para buscar
     * @param idAsignatura          → id de la asignatura de matriculación
     * @return                      → true si está matriculado, false si no lo está
     */
    @Query("""
            SELECT CASE WHEN COUNT(aa) > 0
                THEN TRUE
                ELSE FALSE END
            FROM AlumnoAsignatura AS aa
            WHERE aa.alumno.nif = :nif
                AND aa.asignatura.id = :idAsignatura
            """)
    boolean existeMatricula (
        @Param("nif") String nif,
        @Param("idAsignatura") Integer idAsignatura);

    @Modifying     //Operar en la base de datos 
    @Transactional //Ejecuta una trasanccion
    @Query("""
            DELETE FORM AlumnoAsignatura aa
            WHERE aa.alumno.nif = :nif
            AND aa.asignatura.id = idAsignatura
            """)

    void borrarMatricula(@Param("nif") String nif,@Param("idAsigantura") Integer idAsignatura);
            


}
