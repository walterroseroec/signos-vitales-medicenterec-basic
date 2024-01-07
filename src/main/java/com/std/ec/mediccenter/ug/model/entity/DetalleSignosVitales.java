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
@Table(name = "detalle_signos_vitales")
public class DetalleSignosVitales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_signo_vital", nullable = false)
    private Integer idDetalleSignoVital;

    @Size(max = 50)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    @Size(max = 15)
    @NotNull
    @Column(name = "s_v_descripcion", nullable = false, length = 15)
    private String sVDescripcion;

    @Size(max = 13)
    @NotNull
    @Column(name = "valor", nullable = false, length = 13)
    private String valor;

    @ManyToOne
    @JoinColumn(name = "id_signo_vital")
    private SignosVitales signosVitales;

    @ManyToOne
    @JoinColumn(name = "id_toma_sv")
    private TomaSignosVitales tomaSignosVitales;

}