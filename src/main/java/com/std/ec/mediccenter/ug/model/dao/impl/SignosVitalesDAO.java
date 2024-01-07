package com.std.ec.mediccenter.ug.model.dao.impl;

import com.std.ec.mediccenter.ug.model.dao.Dao;
import com.std.ec.mediccenter.ug.model.dao.interfaces.ISignosVitales;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.SignosVitales;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Stateless
public class SignosVitalesDAO extends Dao<SignosVitales> implements ISignosVitales {

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SignosVitalesDAO() {
        super(SignosVitales.class);
    }

    @Override
    public List<SignosVitales> listar() {
        Query lQuery = em.createQuery("select s from SignosVitales s");
        List<SignosVitales> lists = lQuery.getResultList();
        return lists == null || lists.isEmpty() ? null : lists;
    }
}
