package com.std.ec.mediccenter.ug.model.dao.impl;

import com.std.ec.mediccenter.ug.model.dao.Dao;
import com.std.ec.mediccenter.ug.model.dao.interfaces.IAntecedentes;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Antecedentes;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Stateless
public class AntecedentesDAO extends Dao<Antecedentes> implements IAntecedentes {

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AntecedentesDAO() {
        super(Antecedentes.class);
    }

    @Override
    public List<Antecedentes> listar() {
        Query lQuery = em.createQuery("select a from Antecedentes a");
        List<Antecedentes> aps = lQuery.getResultList();
        return aps == null || aps.isEmpty() ? null : aps;
    }
}
