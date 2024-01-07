package com.std.ec.mediccenter.ug.model.dao.interfaces;

import com.std.ec.mediccenter.ug.model.dao.IDao;
import com.std.ec.mediccenter.ug.model.entity.Antecedentes;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IAntecedentes extends IDao<Antecedentes> {

    List<Antecedentes> listar();

}
