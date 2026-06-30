package com.inserta.backgintoni.modelos;

import java.util.List;

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
@Table(name = "socios")
public class socios {
    @Id
    @Column(length = 9, columnDefinition = "CHAR(9)")
    private String nif;

    @Column(length = 50, nullable = false)
    private String nombre;

    private Integer edad; 

@Column(columnDefinition = "TINYINT(1)")
    private Boolean genero;

    @OneToMany(mappedBy = "socio")
    JsonIgnore
    private List <suscripciones> suscripciones = new ArrayList<>()

}
