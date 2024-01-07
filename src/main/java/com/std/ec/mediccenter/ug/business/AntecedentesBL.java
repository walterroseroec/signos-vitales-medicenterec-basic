package com.std.ec.mediccenter.ug.business;


import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Antecedentes;
import com.std.ec.mediccenter.ug.model.repository.IRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class AntecedentesBL {

    @EJB
    private IRepository repository;
            
    public Antecedentes grabar(Antecedentes ap) {
        return repository.antecedentes().insertar(ap);
    }

    public Antecedentes actualizar(Antecedentes ap) {
        return repository.antecedentes().actualizar(ap);
    }

    public List<Antecedentes> listar() {
        return repository.antecedentes().listar();
    }

    public Antecedentes buscarId(int id) {
        return repository.antecedentes().buscarId(id);
    }

}
