package com.inserta.backgintoni.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="socios")

public class Socio {
@Id
@Column(length = 9,columnDefinition = "CHAR(9)")
private String nif;

@Column(length = 50, nullable = false)
private String nombre;

private Integer edad;
@Column(length = 50,columnDefinition = "CHAR(50)")
private String email;

@Column(columnDefinition = "TYNINT(1)")
private Boolean activo;




}
