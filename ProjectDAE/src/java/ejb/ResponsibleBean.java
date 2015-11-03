/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Event;
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
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Event> listEvents () {
        return entityManager.createNamedQuery("listEvents").getResultList();
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
    
    public void enrollParticipant () {
        
    }
    
    public void unenrollParticipant () {
        
    }
}
