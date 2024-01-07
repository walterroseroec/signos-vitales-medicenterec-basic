package com.std.ec.mediccenter.ug.business;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.SignosVitales;
import com.std.ec.mediccenter.ug.model.repository.IRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class SignosVitalesBL {

    @EJB
    private IRepository repository;

    public SignosVitales grabar(SignosVitales r) {
        return repository.signosVitales().insertar(r);
    }

    public SignosVitales actualizar(SignosVitales r) {
        return repository.signosVitales().actualizar(r);
    }

    public List<SignosVitales> listar() {
        return repository.signosVitales().listar();
    }

    public SignosVitales buscarId(int id) {
        return repository.signosVitales().buscarId(id);
    }

}
