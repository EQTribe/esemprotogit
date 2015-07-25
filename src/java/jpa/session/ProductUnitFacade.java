/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ProductUnit;

/**
 *
 * @author rachnashukla
 */
@Stateless
public class ProductUnitFacade extends AbstractFacade<ProductUnit> {
    @PersistenceContext(unitName = "ESEMProtoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductUnitFacade() {
        super(ProductUnit.class);
    }
    
}
