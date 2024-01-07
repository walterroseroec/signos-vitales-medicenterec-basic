package com.std.ec.mediccenter.ug.model.dao.impl;

import com.std.ec.mediccenter.ug.model.dao.Dao;
import com.std.ec.mediccenter.ug.model.dao.interfaces.IFichaMedica;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.FichaMedica;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Stateless
public class FichaMedicaDAO extends Dao<FichaMedica> implements IFichaMedica {

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichaMedicaDAO() {
        super(FichaMedica.class);
    }

    @Override
    public List<FichaMedica> listar() {
        Query lQuery = em.createQuery("select f from FichaMedica f");
        List<FichaMedica> lists = lQuery.getResultList();
        return lists == null || lists.isEmpty() ? null : lists;
    }
}
