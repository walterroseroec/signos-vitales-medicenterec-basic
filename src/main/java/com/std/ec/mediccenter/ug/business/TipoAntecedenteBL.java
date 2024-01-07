package com.std.ec.mediccenter.ug.business;


import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.TipoAntecedente;
import com.std.ec.mediccenter.ug.model.repository.IRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class TipoAntecedenteBL {

    @EJB
    private IRepository repository;

    public TipoAntecedente grabar(TipoAntecedente ap) {
        return repository.tipoAntecedentes().insertar(ap);
    }

    public TipoAntecedente actualizar(TipoAntecedente ap) {
        return repository.tipoAntecedentes().actualizar(ap);
    }

    public List<TipoAntecedente> listar() {
        return repository.tipoAntecedentes().listar();
    }

    public TipoAntecedente buscarId(int id) {
        return repository.tipoAntecedentes().buscarId(id);
    }

}
