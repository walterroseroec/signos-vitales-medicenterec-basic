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
@Table(name = "tipo_antecedente")
public class TipoAntecedente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_ant", nullable = false)
    private Integer idTipoAnt;

    @Size(max = 15)
    @NotNull
    @Column(name = "abreviatura", nullable = false, length = 15)
    private String abreviatura;

    @Size(max = 100)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

}