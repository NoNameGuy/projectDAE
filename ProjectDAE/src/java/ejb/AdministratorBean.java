/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Administrator;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author paulovieira
 */
@Stateless
public class AdministratorBean {

    @PersistenceContext
    private EntityManager em;

    public void createAdmin(int id, String password, String name, String email) {

        try {
            
            Administrator admin = new Administrator(id, password, name, email);
            em.persist(em);

        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }

    }
    
    
    public void updateAdmin(int id, String password, String name, String email, String role) {
        try {
            Administrator admin = em.find(Administrator.class, id);
            if (admin == null) {
                return;
            }
            admin.setPassword(password);
            admin.setName(name);
            admin.setEmail(email);
            //admin.setRole(role);
            em.merge(admin);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
        public void removeAdmin(int id) {
        try {
            Administrator admin = em.find(Administrator.class, id);
            em.remove(admin);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
}
