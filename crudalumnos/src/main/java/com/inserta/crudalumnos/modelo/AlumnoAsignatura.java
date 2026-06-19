package com.inserta.crudalumnos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

<<<<<<< HEAD
=======
import jakarta.persistence.Column;
>>>>>>> 5206bdef49cc2cceea7014c42d8cf141d5d861c9
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD
//Ojo ! al ser tabla intermedia ponemos en el @table los FKs
=======

// OJO! Al ser tabla intermedia ponemos en el @table los FKs
>>>>>>> 5206bdef49cc2cceea7014c42d8cf141d5d861c9
@Table(name="alumnos_asignaturas",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"alumno_nif", "asignatura_id"}
    )
)
public class AlumnoAsignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD

    private Long id;
    //Las relaciones con objetos!!
    /*@Json ignore sirve para parar la busqueda en la serializacion del JSON,evitando bucles infinitos
    en la salida 
    *Alumnos -> Asignaturas ->¡Alumnos!(aqui se para)
=======
    private Long id;

    // Las relaciones con objetos!!
    /**
     * @JsonIgnore sirve para parar la búsqueda en la serialización del
     * JSON, evitando bucles infinitos en la salida
     * Alumnos -> Asignaturas -> ¡Alumnos! (aquí se parará)
>>>>>>> 5206bdef49cc2cceea7014c42d8cf141d5d861c9
     */
    @ManyToOne
    @JoinColumn(name="alumno_nif")
    @JsonIgnore
    private Alumno alumno;

<<<<<<< HEAD
     @ManyToOne
    @JoinColumn(name="asignatura_id")
    @JsonIgnore
    private Asignatura asignatura;


=======
    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    @JsonIgnore
    private Asignatura asignatura;

>>>>>>> 5206bdef49cc2cceea7014c42d8cf141d5d861c9
}
