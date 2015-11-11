/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entity.Event;
import entity.Responsible;
import exceptions.EntityAlreadyExistsException;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author UTIL
 */
@Stateless
public class ResponsibleBean {
    
    @PersistenceContext(unitName = "ProjectDAEPU")
    private EntityManager em;
    
    public List<Event> listEvents () {
        return em.createNamedQuery("listEvents").getResultList();
    }
    
    //Create Responsible

    public void createResponsible(int id, String password, String name, String email)
        throws EntityAlreadyExistsException {
        try {
            if(em.find(Responsible.class, id) != null){
                throw new EntityAlreadyExistsException("A Responsible with that id already exists.");
            }
            Responsible responsible = new Responsible(id, password, name, email);
            em.persist(responsible);

        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }

    }

    //Responsible Update
    
    public void updateResponsible(int id, String password, String name, String email) {
        try {
            Responsible responsible = em.find(Responsible.class, id);
            if (responsible == null) {
                return;
            }
            responsible.setPassword(password);
            responsible.setName(name);
            responsible.setEmail(email);
            //responsible.setRole(role);
            em.merge(responsible);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    //remove Responsible
    
    public void removeResponsible(int id) {
        try {
            Responsible responsible = em.find(Responsible.class, id);
            em.remove(responsible);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    //Verify if responsible exists
    
    public boolean existeResponsible(String id) {
        try {
            return em.find(Responsible.class, id) != null;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public void createEvent () {
        try {
           // Event event = new Event();
           // entityManager.persist(event);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public void removeEvent () {
        try {
           
            //Event event = entityManager.find(Event.class, this);
            //entityManager.remove(event);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public void openEventAttendance () {
        
    }
    
    public void closeEventAttendance () {
        
    }
    
    public void enrollResponsible () {
        
    }
    
    public void unenrollResponsible () {
        
    }

    public List<Responsible> getAllResponsibles() {
        return em.createNamedQuery("getAllResponsibles").getResultList();
    }
}
