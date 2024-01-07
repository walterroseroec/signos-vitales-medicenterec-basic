package com.std.ec.mediccenter.ug.model.dao.interfaces;

import com.std.ec.mediccenter.ug.model.dao.IDao;
import com.std.ec.mediccenter.ug.model.entity.TomaSignosVitales;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ITomaSignosVitales extends IDao<TomaSignosVitales> {

    List<TomaSignosVitales> listar();

}
