package com.inserta.backgintoni.modelos;

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
@Table(name = "monitores")
public class monitores {
    @Id
@Column(length = 9,columnDefinition = "CHAR(9)")
private  Integer id;

@Column(length = 50, nullable = false)
private String nombre;

private String edad;
@Column(length = 50,columnDefinition = "CHAR(50)")
private String especialidad ;

@Column(length = 50,columnDefinition = "CHAR(50)")
private String email;

@OneToMany(mappedBy = "monitores")
@JsonIgnore
private List<>
}
