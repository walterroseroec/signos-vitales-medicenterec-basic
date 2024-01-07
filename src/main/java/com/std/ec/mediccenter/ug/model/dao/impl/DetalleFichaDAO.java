package com.std.ec.mediccenter.ug.model.dao.impl;

import com.std.ec.mediccenter.ug.model.dao.Dao;
import com.std.ec.mediccenter.ug.model.dao.interfaces.IDetalleFicha;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.DetalleFicha;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Stateless
public class DetalleFichaDAO extends Dao<DetalleFicha> implements IDetalleFicha {

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleFichaDAO() {
        super(DetalleFicha.class);
    }

    @Override
    public List<DetalleFicha> listar() {
        Query lQuery = em.createQuery("select s from DetalleFicha s");
        List<DetalleFicha> lists = lQuery.getResultList();
        return lists == null || lists.isEmpty() ? null : lists;
    }

    @Override
    public List<DetalleFicha> listarPorIdFicha(Integer idFichaMedica) {
        Query lQuery = em.createQuery("select s from DetalleFicha s where s.fichaMedica.idFichaMedica = :idFichaMedica");
        lQuery.setParameter("idFichaMedica", idFichaMedica);
        List<DetalleFicha> lists = lQuery.getResultList();
        return lists == null || lists.isEmpty() ? null : lists;
    }
}
