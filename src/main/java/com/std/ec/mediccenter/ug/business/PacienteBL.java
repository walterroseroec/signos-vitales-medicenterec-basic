package com.std.ec.mediccenter.ug.business;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Paciente;
import com.std.ec.mediccenter.ug.model.repository.IRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class PacienteBL {

    @EJB
    private IRepository repository;

    public Paciente grabar(Paciente p) {
        return repository.paciente().insertar(p);
    }

    public Paciente actualizar(Paciente p) {
        return repository.paciente().actualizar(p);
    }

    public List<Paciente> listar() {
        return repository.paciente().listar();
    }

    public Paciente buscarId(int id) {
        return repository.paciente().buscarId(id);
    }

}
