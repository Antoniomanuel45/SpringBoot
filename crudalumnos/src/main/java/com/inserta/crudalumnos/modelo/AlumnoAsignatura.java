package com.inserta.crudalumnos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
//Ojo ! al ser tabla intermedia ponemos en el @table los FKs
@Table(name="alumnos_asignaturas",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"alumno_nif", "asignatura_id"}
    )
)
public class AlumnoAsignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    //Las relaciones con objetos!!
    /*@Json ignore sirve para parar la busqueda en la serializacion del JSON,evitando bucles infinitos
    en la salida 
    *Alumnos -> Asignaturas ->¡Alumnos!(aqui se para)
     */
    @ManyToOne
    @JoinColumn(name="alumno_nif")
    @JsonIgnore
    private Alumno alumno;

     @ManyToOne
    @JoinColumn(name="asignatura_id")
    @JsonIgnore
    private Asignatura asignatura;


}
