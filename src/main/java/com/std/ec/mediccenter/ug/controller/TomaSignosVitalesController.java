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
@Named("detalleSignosVitalesController")
@ViewScoped
public class TomaSignosVitalesController implements Serializable {

    private TomaSignosVitales tomaSignosVitales;
    private TomaSignosVitales seleccionar;
    private List<TomaSignosVitales> listartomaSignosVitales = new ArrayList<>();
    @EJB
    private TomaSignosVitalesBL tomaSVBL;

    private Enfermero enfermero;
    private Enfermero seleccionarEnfermero;
    private List<Enfermero> listarEnfermero = new ArrayList<>();
    @EJB
    private EnfermeroBL localEnfermeroBL;

    private Paciente paciente;
    private Paciente seleccionarPaciente;
    private List<Paciente> listarPaciente = new ArrayList<>();
    @EJB
    private PacienteBL localPacienteBL;

    private SignosVitales signosVitales;
    private SignosVitales seleccionarSignosVitales;
    private List<SignosVitales> listarSV = new ArrayList<>();
    @EJB
    private SignosVitalesBL localSVBL;

    private DetalleSignosVitales detalleSignosVitales;
    private DetalleSignosVitales seleccionarDetalleSignosVitales;
    private List<DetalleSignosVitales> listarDetalle = new ArrayList<>();
    private List<DetalleSignosVitales> listarDetalleConsul = new ArrayList<>();

    @EJB
    private DetalleSignosVitalesBL localDetalleSignosVitalesBL;

    private FichaMedica fichaMedica = new FichaMedica();
    @EJB
    private FichaMedicaBL locaFichaMedicaB;

    private String edad;

    public TomaSignosVitalesController() {
        tomaSignosVitales = new TomaSignosVitales();
        tomaSignosVitales.setFecha(new Date());
        tomaSignosVitales.setEnfermero(new Enfermero());
        tomaSignosVitales.setPaciente(new Paciente());

        enfermero = new Enfermero();
        paciente = new Paciente();
        signosVitales = new SignosVitales();
        detalleSignosVitales = new DetalleSignosVitales();
        detalleSignosVitales.setTomaSignosVitales(new TomaSignosVitales());

    }

    public List<TomaSignosVitales> getListarSignosVitales() {
        listartomaSignosVitales = tomaSVBL.listar();
        return listartomaSignosVitales;
    }

    public List<Enfermero> getListarEnfermero() {
        listarEnfermero = localEnfermeroBL.listar();
        return listarEnfermero;
    }

    public void setListarEnfermero(List<Enfermero> listarEnfermero) {
        this.listarEnfermero = listarEnfermero;
    }

    public List<Paciente> getListarPaciente() {
        listarPaciente = localPacienteBL.listar();
        return listarPaciente;
    }

    public void setListarPaciente(List<Paciente> listarPaciente) {
        this.listarPaciente = listarPaciente;
    }

    public DetalleSignosVitales getDetalleSignosVitales() {
        return detalleSignosVitales;
    }

    public void setDetalleSignosVitales(DetalleSignosVitales detalleSignosVitales) {
        this.detalleSignosVitales = detalleSignosVitales;
    }

    public List<SignosVitales> getListarSV() {
        listarSV = localSVBL.listar();
        return listarSV;
    }

    //PROCESOS CRUD
    public void guardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (detalleSignosVitales.getIdDetalleSignoVital() == null) {
            tomaSignosVitales.setEnfermero(enfermero);
            tomaSignosVitales.setPaciente(paciente);

            int idToma = tomaSVBL.grabar(tomaSignosVitales).getIdTomaSv();
            System.out.println("toma " + idToma);

            for (DetalleSignosVitales dt : listarDetalle) {
                dt.setTomaSignosVitales(TomaSignosVitales.builder().idTomaSv(idToma).build());
                localDetalleSignosVitalesBL.grabar(dt);
            }

            context.addMessage(null, new FacesMessage("", " Registrado Exitosamente!"));
            nuevo();
        } else {
            localDetalleSignosVitalesBL.actualizar(detalleSignosVitales);
            context.addMessage(null, new FacesMessage("", " Modificado Exitosamente!"));
            nuevo();
        }
        tomaSignosVitales.setFecha(new Date());
    }

    public void accionSeleccionar() {
        if (getSeleccionarSignosVitales() != null) {
            setSignosVitales(getSeleccionarSignosVitales());
        }
    }

    public void accionSeleccionarEnfermero() {
        if (getSeleccionarEnfermero() != null) {
            setEnfermero(getSeleccionarEnfermero());
            getTomaSignosVitales().setEnfermero(getEnfermero());
            //getDetalleSignosVitales().setFichaMedica(getFichaMedica());

            // System.out.println("Enfermero " + getDetalleSignosVitales().getFichaMedica().getEnfermero());
        }
    }

    public List<DetalleSignosVitales> getListarDetalleConsul() {
        listarDetalleConsul = localDetalleSignosVitalesBL.listar();
        return listarDetalleConsul;
    }

    public void setListarDetalleConsul(List<DetalleSignosVitales> listarDetalleConsul) {
        this.listarDetalleConsul = listarDetalleConsul;
    }

    public void accionSeleccionarToma() {
        if (getSeleccionar() != null) {
            setTomaSignosVitales(getSeleccionar());
            setEdad(getEdadCal(getTomaSignosVitales().getPaciente().getFechaNacimiento()));
        }
    }

    public void accionSeleccionarSignos() {
        if (getSeleccionarSignosVitales() != null) {
            getDetalleSignosVitales().setSignosVitales(getSeleccionarSignosVitales());
        }
    }

    public void accionSeleccionarPaciemte() {
        if (getSeleccionarPaciente() != null) {

            setPaciente(getSeleccionarPaciente());
            getTomaSignosVitales().setPaciente(getPaciente());
            setEdad(getEdadCal(getPaciente().getFechaNacimiento()));
        }
    }

    public void nuevo() {
        tomaSignosVitales = new TomaSignosVitales();
        tomaSignosVitales.setFecha(new Date());
        enfermero = new Enfermero();
        paciente = new Paciente();
        signosVitales = new SignosVitales();
        detalleSignosVitales = new DetalleSignosVitales();
        listarDetalle = new ArrayList<>();
        edad = "";

    }

    public void cargarCargos() {
        listartomaSignosVitales = tomaSVBL.listar();
    }

    public void onSeleccionSV() {
        SignosVitales s = detalleSignosVitales.getSignosVitales();
        if (s != null) {
            detalleSignosVitales.setSignosVitales(s);
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
        listarDetalle.add(detalleSignosVitales);
        FacesContext context = FacesContext.getCurrentInstance();

        for (DetalleSignosVitales d : getListarDetalle()) {
            detalleSignosVitales.setValor(detalleSignosVitales.getValor());
            detalleSignosVitales.setSVDescripcion(d.getSignosVitales().getNombre());
            if (detalleSignosVitales.getSVDescripcion().equalsIgnoreCase("Presion")) {
                int presion = Integer.parseInt(d.getValor());
                detalleSignosVitales.setDescripcion(estadoPre(presion));
            } else if (detalleSignosVitales.getSVDescripcion().equalsIgnoreCase("Peso")) {
                detalleSignosVitales.setDescripcion(estadoPesoCal(d.getValor()));
            } else {
                detalleSignosVitales.setDescripcion("Nomral");
            }
            tomaSignosVitales.getDetalleSignosVitalesList().add(detalleSignosVitales);
        }
        detalleSignosVitales = new DetalleSignosVitales();

    }

    public String estadoPesoCal(String p) {
        double peso = Double.parseDouble(p);
        String res = null;
        if (peso <= 18.49) {
            res = "BAJO PESO";
        } else if (peso >= 18.50 && peso <= 24.90) {
            res = "PESO NORMAL";
        } else if (peso >= 25 && peso <= 29.90) {
            res = "SOBRE PESO";
        } else if (peso >= 30 && peso <= 39) {
            res = "OBESIDAD";
        } else if (peso >= 40) {
            res = "OBESIDAD MORBIDA";
        }
        return res;
    }

    public String estadoPre(int pre) {
        String res = null;
        try {
            if (pre <= 79) {
                res = "HIPOTENSION";
            } else if (pre >= 80 && pre <= 119) {
                res = "NORMAL";
            } else if (pre >= 120 && pre <= 139) {
                res = "PREHIPERTENSION";
            } else if (pre >= 140 && pre <= 179) {
                res = "HIPERTENSION";
            } else if (pre >= 180) {
                res = "CRISIs HIPERTENSIVA";
            }
        } catch (Exception e) {
        }
        return res;
    }

    public void consultaaBotonEnfermero() {
        for (Enfermero e : getListarEnfermero()) {
            if (e.getCedula().equals(getTomaSignosVitales().getEnfermero().getCedula())) {
                setEnfermero(e);
            }
        }
        getTomaSignosVitales().setEnfermero(getEnfermero());
    }

    public void consultaaBotonPaciente() {
        for (Paciente e : getListarPaciente()) {
            if (e.getCedula().equals(getTomaSignosVitales().getPaciente().getCedula())) {
                setPaciente(e);
            }
        }
        getTomaSignosVitales().setPaciente(getPaciente());
        setEdad(getEdadCal(getPaciente().getFechaNacimiento()));
    }
}
