package com.std.ec.mediccenter.ug.model.dao.interfaces;

import com.std.ec.mediccenter.ug.model.dao.IDao;
import com.std.ec.mediccenter.ug.model.entity.DetalleSignosVitales;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IDetalleSignosVitales extends IDao<DetalleSignosVitales> {

    List<DetalleSignosVitales> listar();

}
