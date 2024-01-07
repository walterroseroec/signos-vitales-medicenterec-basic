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
@Table(name = "paciente")
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente", nullable = false)
    private Integer idPaciente;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Size(max = 13)
    @NotNull
    @Column(name = "cedula", nullable = false, length = 13)
    private String cedula;

    @Size(max = 10)
    @NotNull
    @Column(name = "celular", nullable = false, length = 10)
    private String celular;

    @Size(max = 50)
    @NotNull
    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;

    @Size(max = 25)
    @NotNull
    @Column(name = "convencional", nullable = false, length = 25)
    private String convencional;

    @Size(max = 200)
    @NotNull
    @Column(name = "direccion", nullable = false, length = 200)
    private String direccion;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @NotNull
    @Column(name = "estado", nullable = false)
    private Boolean estado = false;

    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Lob
    @NotNull
    @Column(name = "foto")
    private byte[] foto;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Size(max = 50)
    @NotNull
    @Column(name = "provincia", nullable = false, length = 50)
    private String provincia;

    @Size(max = 15)
    @NotNull
    @Column(name = "sexo", nullable = false, length = 15)
    private String sexo;

    @Size(max = 10)
    @NotNull
    @Column(name = "tipo_sangre", nullable = false, length = 10)
    private String tipoSangre;

}