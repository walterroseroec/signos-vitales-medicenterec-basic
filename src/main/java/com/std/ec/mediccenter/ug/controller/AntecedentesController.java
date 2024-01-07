package com.std.ec.mediccenter.ug.controller;

import com.std.ec.mediccenter.ug.business.AntecedentesBL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Antecedentes;
import com.std.ec.mediccenter.ug.model.entity.TipoAntecedente;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named("antecedentesController")
@ViewScoped
public class AntecedentesController implements Serializable {

    private Antecedentes antecedente;
    private Antecedentes seleccionar;
    private List<Antecedentes> listarAntecedentes = new ArrayList<>();
    @EJB
    private AntecedentesBL antecedentesBL;

    public List<Antecedentes> getListarAntecedentes() {
        listarAntecedentes = antecedentesBL.listar();
        return listarAntecedentes;
    }

    //PROCESOS CRUD 
    public void guardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (antecedente.getIdAntecedente() == null) {
            antecedentesBL.grabar(antecedente);
            context.addMessage(null, new FacesMessage("", " Registrado Exitosamente!"));
            nuevo();
        } else {
            antecedentesBL.actualizar(antecedente);
            context.addMessage(null, new FacesMessage("", " Modificado Exitosamente!"));
            nuevo();
        }
    }

    public void accionSeleccionar() {
        if (getSeleccionar() != null) {
            setAntecedente(getSeleccionar());
        }
    }

    public void nuevo() {
        antecedente = new Antecedentes();
    }

    public void onSelecciono() {
        TipoAntecedente c = antecedente.getTipoAntecedente();
        if (c != null) {
            antecedente.setTipoAntecedente(c);
        }
    }
}
