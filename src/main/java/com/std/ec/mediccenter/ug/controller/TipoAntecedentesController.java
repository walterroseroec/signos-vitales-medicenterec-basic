package com.std.ec.mediccenter.ug.controller;



import com.std.ec.mediccenter.ug.business.TipoAntecedenteBL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@Named("tipoAntecedentesController")
@ViewScoped
public class TipoAntecedentesController implements Serializable {

    private TipoAntecedente tipoAntecedente;
    private TipoAntecedente seleccionar;
    private List<TipoAntecedente> listarTipoAntecedentes = new ArrayList<>();
    
    @EJB
    private TipoAntecedenteBL tipoAntecedentesBL;

    public List<TipoAntecedente> getListarTipoAntecedentes() {
        listarTipoAntecedentes = tipoAntecedentesBL.listar();
        return listarTipoAntecedentes;
    }

    //PROCESOS CRUD 
    public void guardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (tipoAntecedente.getIdTipoAnt()== null) {
            tipoAntecedentesBL.grabar(tipoAntecedente);
            context.addMessage(null, new FacesMessage("", " Registrado Exitosamente!"));
            nuevo();
        } else {
            tipoAntecedentesBL.actualizar(tipoAntecedente);
            context.addMessage(null, new FacesMessage("", " Modificado Exitosamente!"));
            nuevo();
        }
    }

    public void accionSeleccionar() {
        if (getSeleccionar()!= null) {
            setTipoAntecedente(getSeleccionar());
        }
    }
    
    public void nuevo() {
        tipoAntecedente = new TipoAntecedente();
    }

}
