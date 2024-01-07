package com.std.ec.mediccenter.ug.model.dao.impl;

import com.std.ec.mediccenter.ug.model.dao.Dao;
import com.std.ec.mediccenter.ug.model.dao.interfaces.IEnfermero;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Enfermero;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Stateless
public class EnfermeroDAO extends Dao<Enfermero> implements IEnfermero {

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnfermeroDAO() {
        super(Enfermero.class);
    }

    @Override
    public List<Enfermero> listar() {
        Query lQuery = em.createQuery("select e from Enfermero e order by e.idEnfermero desc");
        List<Enfermero> lists = lQuery.getResultList();
        return lists == null || lists.isEmpty() ? null : lists;
    }
}
