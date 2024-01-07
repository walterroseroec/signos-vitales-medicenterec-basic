package com.std.ec.mediccenter.ug.business;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.FichaMedica;
import com.std.ec.mediccenter.ug.model.entity.Medico;
import com.std.ec.mediccenter.ug.model.entity.Paciente;
import com.std.ec.mediccenter.ug.model.repository.IRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class FichaMedicaBL {

    @EJB
    private IRepository repository;

    public FichaMedica grabar(FichaMedica f) {
        return repository.fichaMedica().insertar(f);
    }

    public FichaMedica actualizar(FichaMedica f) {
        return repository.fichaMedica().actualizar(f);
    }

    public List<FichaMedica> listar() {
        return repository.fichaMedica().listar();
    }

    public FichaMedica buscarId(int id) {
        return repository.fichaMedica().buscarId(id);
    }

    public List<Paciente> listarPacientes() {
        return repository.paciente().listar();
    }

    public List<Medico> listarMedicos() {
        return repository.medico().listar();
    }
}
