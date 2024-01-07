package com.std.ec.mediccenter.ug.model.dao.impl;

import com.std.ec.mediccenter.ug.model.dao.Dao;
import com.std.ec.mediccenter.ug.model.dao.interfaces.ITipoAntecedentes;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.TipoAntecedente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Stateless
public class TipoAntecedentesDAO extends Dao<TipoAntecedente> implements ITipoAntecedentes {

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoAntecedentesDAO() {
        super(TipoAntecedente.class);
    }

    @Override
    public List<TipoAntecedente> listar() {
        Query lQuery = em.createQuery("select a from TipoAntecedente a");
        List<TipoAntecedente> aps = lQuery.getResultList();
        return aps == null || aps.isEmpty() ? null : aps;
    }
}
