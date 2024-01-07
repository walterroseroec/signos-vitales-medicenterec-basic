package com.std.ec.mediccenter.ug.model.dao.interfaces;

import com.std.ec.mediccenter.ug.model.dao.IDao;
import com.std.ec.mediccenter.ug.model.entity.FichaMedica;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IFichaMedica extends IDao<FichaMedica> {

    List<FichaMedica> listar();

}
