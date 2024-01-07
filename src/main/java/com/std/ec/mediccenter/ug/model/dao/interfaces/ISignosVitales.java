package com.std.ec.mediccenter.ug.model.dao.interfaces;

import com.std.ec.mediccenter.ug.model.dao.IDao;
import com.std.ec.mediccenter.ug.model.entity.SignosVitales;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ISignosVitales extends IDao<SignosVitales> {

    List<SignosVitales> listar();

}