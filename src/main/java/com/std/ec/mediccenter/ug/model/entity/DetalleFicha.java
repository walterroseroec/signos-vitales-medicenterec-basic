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
@Table(name = "detalle_ficha")
public class DetalleFicha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_ficha", nullable = false)
    private Integer idDetalleFicha;

    @Size(max = 255)
    @NotNull
    @Column(name = "observacion", nullable = false)
    private String observacion;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_antecedente", nullable = false)
    private Antecedentes antecedentes;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_ficha_medica", nullable = false)
    private FichaMedica fichaMedica;

}