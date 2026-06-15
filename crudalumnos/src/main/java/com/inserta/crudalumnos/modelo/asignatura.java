package com.inserta.crudalumnos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="asignaturas")

public class asignatura {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;   //SQL -> ID INT AUTO_INCREMENT

@Column(length = 50, nullable=true)
private String denominacion;
@Column(columnDefinition = "TINYINT")
private int curso;      //SQL -> curso TINYINT NULL


// Falta poner las relaciones con la tabla secundaria 


}
