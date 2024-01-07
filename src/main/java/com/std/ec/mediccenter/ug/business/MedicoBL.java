package com.std.ec.mediccenter.ug.business;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Medico;
import com.std.ec.mediccenter.ug.model.repository.IRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;


@Stateless
@LocalBean
public class MedicoBL {

    @EJB
    private IRepository repository;

    public Medico grabar(Medico m) {
        return repository.medico().insertar(m);
    }

    public Medico actualizar(Medico m) {
        return repository.medico().actualizar(m);
    }

    public List<Medico> listar() {
        return repository.medico().listar();
    }

    public Medico buscarId(int id) {
        return repository.medico().buscarId(id);
    }

}
