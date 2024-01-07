package com.std.ec.mediccenter.ug.controller;


import com.std.ec.mediccenter.ug.business.PacienteBL;

import java.io.Serializable;
import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Paciente;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named("pacienteImgenMB")
@ApplicationScoped
public class PacienteImgenController implements Serializable {

    @EJB
    private PacienteBL pacienteBL;

    private List<Paciente> pacientes = null;
    private Paciente paciente;

    public PacienteImgenController() {
    }

    @PostConstruct
    public void init() {
        paciente = new Paciente();
    }

    public Paciente getPacienteID(Integer id) {
        return pacienteBL.buscarId(id);
    }
    
    public byte[] getPacienteImagen(Integer id) {
        return getPacienteID(id).getFoto();
    }


}
