package com.std.ec.mediccenter.ug.business;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.DetalleFicha;
import com.std.ec.mediccenter.ug.model.repository.IRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class DetalleFichaBL {

    @EJB
    private IRepository repository;

    public DetalleFicha grabar(DetalleFicha r) {
        return repository.detalleFicha().insertar(r);
    }

    public DetalleFicha actualizar(DetalleFicha r) {
        return repository.detalleFicha().actualizar(r);
    }

    public List<DetalleFicha> listar() {
        return repository.detalleFicha().listar();
    }

    public DetalleFicha buscarId(int id) {
        return repository.detalleFicha().buscarId(id);
    }

    public List<DetalleFicha> listarPorIdFicha(Integer idFichaMedica){
        return repository.detalleFicha().listarPorIdFicha(idFichaMedica);
    }
}
