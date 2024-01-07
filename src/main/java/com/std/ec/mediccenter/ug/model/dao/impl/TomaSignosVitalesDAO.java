package com.std.ec.mediccenter.ug.model.dao.impl;

import com.std.ec.mediccenter.ug.model.dao.Dao;
import com.std.ec.mediccenter.ug.model.dao.interfaces.ITomaSignosVitales;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.TomaSignosVitales;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Stateless
public class TomaSignosVitalesDAO extends Dao<TomaSignosVitales> implements ITomaSignosVitales {

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TomaSignosVitalesDAO() {
        super(TomaSignosVitales.class);
    }

    @Override
    public List<TomaSignosVitales> listar() {
        Query lQuery = em.createQuery("select f from TomaSignosVitales f");
        List<TomaSignosVitales> lists = lQuery.getResultList();
        return lists == null || lists.isEmpty() ? null : lists;
    }
}
