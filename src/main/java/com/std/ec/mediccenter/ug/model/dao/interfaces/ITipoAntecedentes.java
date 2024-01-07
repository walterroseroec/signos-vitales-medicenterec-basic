package com.std.ec.mediccenter.ug.model.dao.interfaces;

import com.std.ec.mediccenter.ug.model.dao.IDao;
import com.std.ec.mediccenter.ug.model.entity.TipoAntecedente;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ITipoAntecedentes extends IDao<TipoAntecedente> {

    List<TipoAntecedente> listar();

}
