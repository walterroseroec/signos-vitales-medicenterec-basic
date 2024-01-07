package com.std.ec.mediccenter.ug.model.dao.interfaces;

import com.std.ec.mediccenter.ug.model.dao.IDao;
import com.std.ec.mediccenter.ug.model.entity.Medico;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IMedico extends IDao<Medico> {

    List<Medico> listar();

}
