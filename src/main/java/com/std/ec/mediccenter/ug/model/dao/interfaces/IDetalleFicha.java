package com.std.ec.mediccenter.ug.model.dao.interfaces;

import com.std.ec.mediccenter.ug.model.dao.IDao;
import com.std.ec.mediccenter.ug.model.entity.DetalleFicha;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IDetalleFicha extends IDao<DetalleFicha> {

    List<DetalleFicha> listar();

    List<DetalleFicha> listarPorIdFicha(Integer idFichaMedica);

}
