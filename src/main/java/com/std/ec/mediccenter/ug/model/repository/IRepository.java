package com.std.ec.mediccenter.ug.model.repository;


import com.std.ec.mediccenter.ug.model.dao.interfaces.*;
import jakarta.ejb.Local;

import java.io.Serializable;

/**
 * @author Walter Rosero
 */
@Local
public interface IRepository extends Serializable {

    IAntecedentes antecedentes();

    IDetalleFicha detalleFicha();

    IDetalleSignosVitales detalleSignosVitales();

    IEnfermero enfermero();

    IEspecialidad especialidad();

    IFichaMedica fichaMedica();

    IMedico medico();

    IPaciente paciente();

    ISignosVitales signosVitales();

    ITipoAntecedentes tipoAntecedentes();

    ITomaSignosVitales tomaSignosVitales();

}
