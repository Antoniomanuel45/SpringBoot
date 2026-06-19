package com.inserta.laqueseavecina.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="servicios",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"vecinos_apartamentos","trabajadores_nif"}

    )
)

public class Servicios {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@ManyToOne
@JoinColumn(name = "vecino_apartamento")
@JsonIgnore
private Vecinos vecino;

@ManyToOne
@JoinColumn(name = "trabajadores_nif")
@JsonIgnore
private Trabajadores trabajador;

}
