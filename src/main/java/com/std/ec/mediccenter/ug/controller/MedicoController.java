package com.std.ec.mediccenter.ug.controller;

import com.std.ec.mediccenter.ug.business.MedicoBL;

import java.io.Serializable;
import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Especialidad;
import com.std.ec.mediccenter.ug.model.entity.Medico;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named("medicoController")
@ViewScoped
public class MedicoController implements Serializable {

    private Medico medico;
    private Medico seleccionar;
    private List<Medico> listar = null;

    @EJB
    private MedicoBL local;

    private Especialidad especialidad;

    public MedicoController() {
        medico = new Medico();
        especialidad = new Especialidad();
    }

    public List<Medico> getListar() {
        listar = local.listar();
        return listar;
    }

    //PROCESOS CRUD 
    public void guardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (medico.getIdMedico() == null) {
            local.grabar(medico);
            context.addMessage(null, new FacesMessage("", " Registrado Exitosamente!"));
            nuevo();
        } else {
            local.actualizar(medico);
            context.addMessage(null, new FacesMessage("", " Modificado Exitosamente!"));
            nuevo();
        }
    }

    public void accionSeleccionar() {
        if (getSeleccionar() != null) {
            setMedico(getSeleccionar());
        }
    }

    public void nuevo() {
        medico = new Medico();
    }

    public void onSeleccionMedico() {
        Especialidad c = medico.getEspecialidad();
        if (c != null) {
            medico.setEspecialidad(c);
        }
    }

}
