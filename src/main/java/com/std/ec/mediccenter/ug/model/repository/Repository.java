package com.std.ec.mediccenter.ug.model.repository;

import com.std.ec.mediccenter.ug.model.dao.interfaces.*;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.io.Serializable;

/**
 * @author Walter Rosero
 */
@Stateless
public class Repository implements IRepository, Serializable {

    @EJB
    private IAntecedentes antecedentes;

    @EJB
    private IDetalleFicha detalleFicha;

    @EJB
    private IDetalleSignosVitales detalleSignosVitales;

    @EJB
    private IEnfermero enfermero;

    @EJB
    private IEspecialidad especialidad;

    @EJB
    private IFichaMedica fichaMedica;

    @EJB
    private IMedico medico;

    @EJB
    private IPaciente paciente;

    @EJB
    private ISignosVitales signosVitales;

    @EJB
    private ITipoAntecedentes tipoAntecedentes;

    @EJB
    private ITomaSignosVitales tomaSignosVitales;

    @Override
    public IAntecedentes antecedentes() {
        return this.antecedentes;
    }

    @Override
    public IDetalleFicha detalleFicha() {
        return this.detalleFicha;
    }

    @Override
    public IDetalleSignosVitales detalleSignosVitales() {
        return this.detalleSignosVitales;
    }

    @Override
    public IEnfermero enfermero() {
        return this.enfermero;
    }

    @Override
    public IEspecialidad especialidad() {
        return this.especialidad;
    }

    @Override
    public IFichaMedica fichaMedica() {
        return this.fichaMedica;
    }

    @Override
    public IMedico medico() {
        return this.medico;
    }

    @Override
    public IPaciente paciente() {
        return this.paciente;
    }

    @Override
    public ISignosVitales signosVitales() {
        return this.signosVitales;
    }

    @Override
    public ITipoAntecedentes tipoAntecedentes() {
        return this.tipoAntecedentes;
    }

    @Override
    public ITomaSignosVitales tomaSignosVitales() {
        return this.tomaSignosVitales;
    }
}
