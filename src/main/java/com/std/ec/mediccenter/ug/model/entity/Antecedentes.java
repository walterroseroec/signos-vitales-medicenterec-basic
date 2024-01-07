package com.std.ec.mediccenter.ug.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "antecedentes")
public class Antecedentes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_antecedente", nullable = false)
    private Integer idAntecedente;

    @Size(max = 15)
    @NotNull
    @Column(name = "abreviatura", nullable = false, length = 15)
    private String abreviatura;

    @Size(max = 200)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_tipo_ant", nullable = false)
    private TipoAntecedente tipoAntecedente;

}