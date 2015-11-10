/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entity.Administrator;
import entity.Event;
import entity.Responsible;
import java.util.Date;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author UTIL
 */
@Stateless
public class EventBean {

    @PersistenceContext
    private EntityManager em;
    
    /*public List<String> list() {
        
    }*/
    
    public void createEvent(int id, Date date, String name, String type, String local, long responsableId) {
        
        try {
            if(em.find(Event.class, id) != null){
                return;
            }
            Responsible responsible = em.find(Responsible.class, responsableId);
            if (responsible == null) {
                return;
            }
            Event event = new Event(id, date, name, type, local, responsible);
            em.persist(event);

        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public void updateEvent() {
        
    }
    
    public void deleteEvent() {
        
    }
}
