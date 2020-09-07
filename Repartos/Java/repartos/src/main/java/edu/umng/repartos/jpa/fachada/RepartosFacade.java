/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umng.repartos.jpa.fachada;

import edu.umng.repartos.jpa.entities.Repartos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jamesit0
 */
@Stateless
public class RepartosFacade extends AbstractFacade<Repartos> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepartosFacade() {
        super(Repartos.class);
    }
    
}
