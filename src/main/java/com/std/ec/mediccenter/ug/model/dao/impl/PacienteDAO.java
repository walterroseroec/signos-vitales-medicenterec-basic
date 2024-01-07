package com.std.ec.mediccenter.ug.model.dao.impl;

import com.std.ec.mediccenter.ug.model.dao.Dao;
import com.std.ec.mediccenter.ug.model.dao.interfaces.IPaciente;

import java.util.List;

import com.std.ec.mediccenter.ug.model.entity.Paciente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Stateless
public class PacienteDAO extends Dao<Paciente> implements IPaciente {

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacienteDAO() {
        super(Paciente.class);
    }

    @Override
    public List<Paciente> listar() {
        Query lQuery = em.createQuery("select p from Paciente p");
        List<Paciente> lists = lQuery.getResultList();
        return lists == null || lists.isEmpty() ? null : lists;
    }
}
