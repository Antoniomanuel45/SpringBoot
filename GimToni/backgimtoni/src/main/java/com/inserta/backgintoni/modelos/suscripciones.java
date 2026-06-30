package com.inserta.backgintoni.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


@Table(name = "suscripciones")
public class suscripciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "socio_nif", referencedColumnName = "nif", nullable = false)
    private socios socio;

    @ManyToOne
    @JoinColumn(name = "monitor_id", nullable = false)
    private monitores monitor;

    @ManyToOne
    @JoinColumn(name = "actividad_id", nullable = false)
    private actividades actividad;

    @Column(nullable = false)
    private LocalDate fechaAlta;

    @Column(nullable = false)
    private Boolean activa;
}


   


