package com.std.ec.mediccenter.ug.controller;

import com.std.ec.mediccenter.ug.business.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.*;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named("fichaMedicaController")
@ViewScoped
public class FichaMedicaController implements Serializable {


    private FichaMedica fichaMedica;
    private FichaMedica seleccionar;
    private List<FichaMedica> listarFichaMedicas = new ArrayList<>();
    @EJB
    private FichaMedicaBL localFichaMedicaB;

    private Medico medico;
    private Medico seleccionarMedico;
    private List<Medico> listarMedicos = new ArrayList<>();
    @EJB
    private MedicoBL localMedicoB;

    private Paciente paciente;
    private Paciente seleccionarPaciente;
    private List<Paciente> listarPaciente = new ArrayList<>();
    @EJB
    private PacienteBL localPacienteBL;

    private Antecedentes antecedentes;
    private Antecedentes seleccionarSignosVitales;
    private List<Antecedentes> listarAntecedenteses = new ArrayList<>();
    @EJB
    private AntecedentesBL localanAntecedentesB;

    private DetalleFicha detalleFicha;
    private DetalleFicha seleccionarDetalleFicha;
    private List<DetalleFicha> listarDetalle = new ArrayList<>();
    private List<DetalleFicha> listarFichaMedicConsul = new ArrayList<>();
    @EJB
    private DetalleFichaBL localDetalleFichaB;

    private String edad;

    public FichaMedicaController() {
        fichaMedica = new FichaMedica();
        fichaMedica.setFecha(new Date());
        fichaMedica.setMedico(new Medico());
        fichaMedica.setPaciente(new Paciente());
        medico = new Medico();
        paciente = new Paciente();
        antecedentes = new Antecedentes();
        detalleFicha = new DetalleFicha();
        detalleFicha.setFichaMedica(new FichaMedica());

    }

    public List<FichaMedica> getListarFichaMedicas() {
        listarFichaMedicas = localFichaMedicaB.listar();
        return listarFichaMedicas;
    }

    public List<Medico> getListarMedicos() {
        listarMedicos = localMedicoB.listar();
        return listarMedicos;
    }

    public List<Paciente> getListarPaciente() {
        listarPaciente = localPacienteBL.listar();
        return listarPaciente;
    }

    public List<Antecedentes> getListarAnt() {
        listarAntecedenteses = localanAntecedentesB.listar();
        return listarAntecedenteses;
    }

    //PROCESOS CRUD
    public void guardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (fichaMedica.getIdFichaMedica() == null) {
            fichaMedica.setMedico(medico);
            fichaMedica.setPaciente(paciente);

            int idToma = localFichaMedicaB.grabar(fichaMedica).getIdFichaMedica();
            System.out.println("toma " + idToma);

            for (DetalleFicha dt : listarDetalle) {
                dt.setFichaMedica(FichaMedica.builder().idFichaMedica(idToma).build());
                localDetalleFichaB.grabar(dt);
            }

            context.addMessage(null, new FacesMessage("", " Registrado Exitosamente!"));
            nuevo();
        } else {
            localFichaMedicaB.actualizar(fichaMedica);
            context.addMessage(null, new FacesMessage("", " Modificado Exitosamente!"));
            nuevo();
        }
        fichaMedica.setFecha(new Date());
    }

    public void accionSeleccionarMedico() {
        if (getSeleccionarMedico() != null) {
            setMedico(getSeleccionarMedico());
            getFichaMedica().setMedico(getMedico());

        }
    }

    public void accionSeleccionarPaciemte() {
        if (getSeleccionarPaciente() != null) {

            setPaciente(getSeleccionarPaciente());
            getFichaMedica().setPaciente(getPaciente());

            setEdad(getEdadCal(getPaciente().getFechaNacimiento()));

        }
    }

    public void nuevo() {
        fichaMedica = new FichaMedica();
        fichaMedica.setFecha(new Date());
        medico = new Medico();
        paciente = new Paciente();
        antecedentes = new Antecedentes();
        detalleFicha = new DetalleFicha();
        listarDetalle = new ArrayList<>();
    }

    public void cargarCargos() {
        listarFichaMedicas = localFichaMedicaB.listar();
    }

    public void onSeleccionAnt() {
        Antecedentes s = detalleFicha.getAntecedentes();
        if (s != null) {
            detalleFicha.setAntecedentes(s);
        }
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public static String getEdadCal(Date fechaNacimiento) {
        if (fechaNacimiento != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            StringBuilder result = new StringBuilder();
            if (fechaNacimiento != null) {
                Calendar c = new GregorianCalendar();
                c.setTime(fechaNacimiento);
                result.append(calcularEdad(c));
            }
            return result.toString();
        }
        return "";
    }

    private static int calcularEdad(Calendar fechaNac) {
        Calendar today = Calendar.getInstance();
        int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
        // Si está en ese año pero todavía no los ha cumplido
        if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
            diffYear = diffYear - 1;
        }
        return diffYear;
    }

    public void accionAgregar() {
        listarDetalle.add(detalleFicha);
        for (DetalleFicha d : listarDetalle) {
            detalleFicha.setObservacion(d.getAntecedentes().getNombre());
            //fichaMedica.getDetalleFicha().add(detalleFicha);
        }
        detalleFicha = new DetalleFicha();
    }

    public void consultaaBotonMedico() {
        for (Medico e : getListarMedicos()) {
            if (e.getCedula().equals(getFichaMedica().getMedico().getCedula())) {
                setMedico(e);
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
            }
        }
        getFichaMedica().setMedico(getMedico());
    }

    public void consultaaBotonPaciente() {
        FacesContext context = FacesContext.getCurrentInstance();
        for (Paciente e : getListarPaciente()) {
            if (e.getCedula().equals(getFichaMedica().getPaciente().getCedula())) {
                setPaciente(e);
            } else {
                context.addMessage(null, new FacesMessage("", "No existe Numero de cedula!"));
            }
        }
        getFichaMedica().setPaciente(getPaciente());
        setEdad(getEdadCal(getPaciente().getFechaNacimiento()));

    }


    public void accionSeleccionarToma() {
        if (getSeleccionar() != null) {
            listarDetalle = localDetalleFichaB.listarPorIdFicha(getSeleccionar().getIdFichaMedica());
            setFichaMedica(getSeleccionar());
            setEdad(getEdadCal(getFichaMedica().getPaciente().getFechaNacimiento()));
        }
    }
}
