package com.std.ec.mediccenter.ug.model.dao.interfaces;

import com.std.ec.mediccenter.ug.model.dao.IDao;
import com.std.ec.mediccenter.ug.model.entity.Enfermero;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IEnfermero extends IDao<Enfermero> {

    List<Enfermero> listar();

}
