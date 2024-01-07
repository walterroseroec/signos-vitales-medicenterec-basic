package com.std.ec.mediccenter.ug.controller;

import com.std.ec.mediccenter.ug.business.EnfermeroBL;

import java.io.Serializable;
import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Enfermero;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named("enfermeroController")
@ViewScoped
public class EnfermeroController implements Serializable {

    private Enfermero enfermero;
    private Enfermero seleccionar;
    private List<Enfermero> listar = null;

    @EJB
    private EnfermeroBL local;

    public EnfermeroController() {
        enfermero = new Enfermero();
    }

    public List<Enfermero> getListar() {
        return listar = local.listar();
    }

    //PROCESOS CRUD 
    public void guardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (enfermero.getIdEnfermero() == null) {
            local.grabar(enfermero);
            context.addMessage(null, new FacesMessage("", " Registrado Exitosamente!"));
            nuevo();
        } else {
            local.actualizar(enfermero);
            context.addMessage(null, new FacesMessage("", " Modificado Exitosamente!"));
            nuevo();
        }
    }

    public void accionSeleccionar() {
        if (getSeleccionar() != null) {
            setEnfermero(getSeleccionar());
        }
    }

    public void nuevo() {
        enfermero = new Enfermero();
    }

}
