package com.std.ec.mediccenter.ug.controller;


import com.std.ec.mediccenter.ug.business.SignosVitalesBL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.SignosVitales;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named("signosVitalesController")
@ViewScoped
public class SignosVitalesController implements Serializable {

    private SignosVitales signosVitales;
    private SignosVitales seleccionarSignosVitales;
    private List<SignosVitales> listarSignosVitales = new ArrayList<>();
    
    @EJB
    private SignosVitalesBL localSignosVitalesBL;


    public SignosVitalesController() {
        signosVitales = new SignosVitales();
    }

    public List<SignosVitales> getListarSignosVitales() {
        listarSignosVitales = localSignosVitalesBL.listar();
        return listarSignosVitales;
    }

    //PROCESOS CRUD 
    public void guardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (signosVitales.getIdSignoVital() == null) {
            localSignosVitalesBL.grabar(signosVitales);
            context.addMessage(null, new FacesMessage("", " Registrado Exitosamente!"));
            nuevo();
        } else {
            localSignosVitalesBL.actualizar(signosVitales);
            context.addMessage(null, new FacesMessage("", " Modificado Exitosamente!"));
            nuevo();
        }
    }

    public void accionSeleccionar() {
        if (getSeleccionarSignosVitales() != null) {
            setSignosVitales(getSeleccionarSignosVitales());
        }
    }
    
    public void nuevo() {
        signosVitales = new SignosVitales();
    }
 
}
