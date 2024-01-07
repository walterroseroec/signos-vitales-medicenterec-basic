package com.std.ec.mediccenter.ug.model.dao.interfaces;

import com.std.ec.mediccenter.ug.model.dao.IDao;
import com.std.ec.mediccenter.ug.model.entity.Paciente;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IPaciente extends IDao<Paciente> {

    List<Paciente> listar();

}
