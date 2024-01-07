package com.std.ec.mediccenter.ug.controller;

import com.std.ec.mediccenter.ug.business.PacienteBL;

import com.std.ec.mediccenter.ug.model.entity.Paciente;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.IOUtils;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

@Getter
@Setter
@Named("pacienteController")
@ViewScoped
public class PacienteController implements Serializable {

    private Paciente paciente;
    private Paciente seleccionar;
    private List<Paciente> listar = null;

    @EJB
    private PacienteBL local;

    public PacienteController() {
        paciente = new Paciente();
    }

    public List<Paciente> getListar() {
        listar = local.listar();
        return listar;
    }

    //PROCESOS CRUD 
    public void guardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (paciente.getIdPaciente() == null) {
            local.grabar(paciente);
            context.addMessage(null, new FacesMessage("", " Registrado Exitosamente!"));
            nuevo();
        } else {
            local.actualizar(paciente);
            context.addMessage(null, new FacesMessage("", " Modificado Exitosamente!"));
            nuevo();
        }
    }

    public void accionSeleccionar() {
        if (getSeleccionar() != null) {
            setPaciente(getSeleccionar());
        }
    }

    public void nuevo() {
        paciente = new Paciente();
    }


    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {
            byte[] content = IOUtils.toByteArray(event.getFile().getInputStream());

            paciente.setFoto(content);
            FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " subido.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            System.out.println("File uploaded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
