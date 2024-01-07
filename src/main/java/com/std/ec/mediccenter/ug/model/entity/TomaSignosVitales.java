package com.std.ec.mediccenter.ug.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "toma_signos_vitales")
public class TomaSignosVitales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_toma_sv", nullable = false)
    private Integer idTomaSv;

    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_enfermero", nullable = false)
    private Enfermero enfermero;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @OneToMany( mappedBy = "tomaSignosVitales", fetch = FetchType.EAGER)
    private List<DetalleSignosVitales> detalleSignosVitalesList = new ArrayList<>();

}