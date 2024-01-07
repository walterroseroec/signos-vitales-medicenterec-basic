package com.std.ec.mediccenter.ug.business;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Enfermero;
import com.std.ec.mediccenter.ug.model.entity.Paciente;
import com.std.ec.mediccenter.ug.model.entity.TomaSignosVitales;
import com.std.ec.mediccenter.ug.model.repository.IRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class TomaSignosVitalesBL {

    @EJB
    private IRepository repository;

    public TomaSignosVitales grabar(TomaSignosVitales f) {
       return repository.tomaSignosVitales().insertar(f);
    }

    public TomaSignosVitales actualizar(TomaSignosVitales f) {
        return repository.tomaSignosVitales().actualizar(f);
    }

    public List<TomaSignosVitales> listar() {
        return repository.tomaSignosVitales().listar();
    }

    public TomaSignosVitales buscarId(int id) {
        return repository.tomaSignosVitales().buscarId(id);
    }

    public List<Enfermero> listarEnfermeros() {
        return repository.enfermero().listar();
    }

    public List<Paciente> listarPacientes() {
        return repository.paciente().listar();
    }

}
