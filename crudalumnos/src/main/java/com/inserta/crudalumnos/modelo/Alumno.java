package com.inserta.crudalumnos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="alumnos")
public class Alumno {
    @Id
    @Column(length = 9,columnDefinition = "CHAR(9)")
    private String nif;
    
    //Resto de los campos (siempre PRIVADOS!!!)
    @Column(length = 50,nullable = false)
    //Resto de los campos (siempre PRIVADOS!!!)
    private String nombre;    //SQL -> nombre VARCHAR(50) NOT NULL
    // Aqui por ejemplo No le ponemos ninguna etiqueta (@Column)
    private Integer edad;  // SQL -> edad INT NULL

    @Column(columnDefinition = "TINYINT(1)")
    private boolean genero;

    //Se añade las relaciones en tabla principal 


    

    
}
