package com.std.ec.mediccenter.ug.business;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Enfermero;
import com.std.ec.mediccenter.ug.model.repository.IRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class EnfermeroBL {

    @EJB
    private IRepository repository;

    public Enfermero grabar(Enfermero e) {
        return repository.enfermero().insertar(e);
    }

    public Enfermero actualizar(Enfermero e) {
        return repository.enfermero().actualizar(e);
    }

    public List<Enfermero> listar() {
        return repository.enfermero().listar();
    }

    public Enfermero buscarId(int id) {
        return repository.enfermero().buscarId(id);
    }

}
