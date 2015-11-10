/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entity.Administrator;
import java.util.List;
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

    @PersistenceContext(unitName = "ProjectDAEPU")
    private EntityManager em;
    
    //Create Admin

    public void createAdmin(int id, String password, String name, String email) {
        try {
            if(em.find(Administrator.class, id) != null){
                return;
            }
            em.persist(new Administrator(id, password, name, email));
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    //Admin Update
    
    public void updateAdmin(int id, String name, String email, String password) {
        try {
            Administrator administrator = em.find(Administrator.class, id);
            if (administrator == null) {
                return;
            }
            administrator.setPassword(password);
            administrator.setName(name);
            administrator.setEmail(email);
            em.merge(administrator);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    //remove admin
    
    public void removeAdmin(int id) {
        try {
            Administrator admin = em.find(Administrator.class, id);
            em.remove(admin);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    //Verify if admin exists
    
    public boolean existeAdmin(int id) {
        try {
            return (em.find(Administrator.class, id) != null);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public List<Administrator> getAllAdministrators() {
        return em.createNamedQuery("getAllAdministrators").getResultList();
    }




}
