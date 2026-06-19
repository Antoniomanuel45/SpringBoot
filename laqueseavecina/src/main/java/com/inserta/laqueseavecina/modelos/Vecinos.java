package com.inserta.laqueseavecina.modelos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;

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
@Table(name="vecinos")

public class Vecinos {
    @Id
    @Column(length = 3,columnDefinition = "CHAR(3)")
    private String apartamento;

    @Column(length = 3, columnDefinition = "CHAR(3)")
    private String plaza;

@Column(columnDefinition = "TINYINT(1)")
    private boolean alquilado;
    
    @OneToMany(mappedBy = "vecino")
    private List <Servicios> servicio = new ArrayList<>();






}
