package com.std.ec.mediccenter.ug.model.dao.impl;

import com.std.ec.mediccenter.ug.model.dao.Dao;
import com.std.ec.mediccenter.ug.model.dao.interfaces.IMedico;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Medico;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Stateless
public class MedicoDAO extends Dao<Medico> implements IMedico {

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicoDAO() {
        super(Medico.class);
    }

    @Override
    public List<Medico> listar() {
        Query lQuery = em.createQuery("select m from Medico m");
        List<Medico> lists = lQuery.getResultList();
        return lists == null || lists.isEmpty() ? null : lists;
    }
}
