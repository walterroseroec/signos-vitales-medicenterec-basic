package com.std.ec.mediccenter.ug.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "enfermero")
public class Enfermero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enfermero", nullable = false)
    private Integer idEnfermero;

    @Size(max = 120)
    @NotNull
    @Column(name = "apellidos", nullable = false, length = 120)
    private String apellidos;

    @Size(max = 13)
    @NotNull
    @Column(name = "cedula", nullable = false, length = 13)
    private String cedula;

    @Size(max = 10)
    @NotNull
    @Column(name = "celular", nullable = false, length = 10)
    private String celular;

    @Size(max = 200)
    @NotNull
    @Column(name = "direccion", nullable = false, length = 200)
    private String direccion;

    @NotNull
    @Column(name = "estado", nullable = false)
    private Boolean estado = false;

    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Size(max = 120)
    @NotNull
    @Column(name = "nombres", nullable = false, length = 120)
    private String nombres;

}