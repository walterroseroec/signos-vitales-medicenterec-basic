package com.std.ec.mediccenter.ug.business;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.DetalleSignosVitales;
import com.std.ec.mediccenter.ug.model.repository.IRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

@Stateless
@LocalBean
public class DetalleSignosVitalesBL {

    @EJB
    private IRepository repository;

    public DetalleSignosVitales grabar(DetalleSignosVitales r) {
        return repository.detalleSignosVitales().insertar(r);
    }

    public DetalleSignosVitales actualizar(DetalleSignosVitales r) {
        return repository.detalleSignosVitales().actualizar(r);
    }

    public List<DetalleSignosVitales> listar() {
        return repository.detalleSignosVitales().listar();
    }

    public DetalleSignosVitales buscarId(int id) {
        return repository.detalleSignosVitales().buscarId(id);
    }

}
