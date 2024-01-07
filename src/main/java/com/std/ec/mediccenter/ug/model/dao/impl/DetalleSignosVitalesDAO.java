package com.std.ec.mediccenter.ug.model.dao.impl;

import com.std.ec.mediccenter.ug.model.dao.Dao;
import com.std.ec.mediccenter.ug.model.dao.interfaces.IDetalleSignosVitales;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.DetalleSignosVitales;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Stateless
public class DetalleSignosVitalesDAO extends Dao<DetalleSignosVitales> implements IDetalleSignosVitales {

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleSignosVitalesDAO() {
        super(DetalleSignosVitales.class);
    }

    @Override
    public List<DetalleSignosVitales> listar() {
        Query lQuery = em.createQuery("select s from DetalleSignosVitales s");
        List<DetalleSignosVitales> lists = lQuery.getResultList();
        return lists == null || lists.isEmpty() ? null : lists;
    }
}
