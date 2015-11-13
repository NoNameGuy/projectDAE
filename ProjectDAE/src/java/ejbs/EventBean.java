/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.EventDTO;
import entity.Event;
import entity.Participant;
import entity.Responsible;
import exceptions.EntityAlreadyExistsException;
import exceptions.EntityDoesNotExistsException;
import exceptions.MyConstraintViolationException;
import exceptions.Utils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author UTIL
 */
@Stateless
public class EventBean {

    @PersistenceContext(unitName = "ProjectDAEPU")
    private EntityManager em;

    /*public List<String> list() {
        
    }*/
    public void createEvent(int id, Date date, String name, String type, String local, int responsableId)
            throws EntityAlreadyExistsException, EntityDoesNotExistsException, MyConstraintViolationException {
        try {

            if (em.find(Event.class, id) != null) {
                throw new EntityAlreadyExistsException("A Event with that id already exists.");
            }
            Responsible responsible = em.find(Responsible.class, responsableId);
            if (responsible == null) {
                throw new EntityDoesNotExistsException("There is no Responsible with that code.");
            }
            Event event = new Event(id, date, name, type, local, responsible);
            em.persist(event);

        } catch (EntityAlreadyExistsException | EntityDoesNotExistsException e) {
            throw e;
        } catch (ConstraintViolationException e) {
            throw new MyConstraintViolationException(Utils.getConstraintViolationMessages(e));
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public void updateEvent() {

    }

    public void deleteEvent(int id) {
        try {
            Event event = em.find(Event.class, id);
            if (event == null) {
                return;
            }

            event.getResponsible().removeEvent(event);

            for (Participant participant : event.getParticipants()) {
                event.removeParticipant(participant);
            }

            em.remove(event);

        } catch (Exception e) {
            throw e;
        }
    }

    public List<EventDTO> getAllEvents() {
        List<Event> events = (List<Event>) em.createNamedQuery("getAllEvents").getResultList();
        return eventsToDTOs(events);
    }
    
    public List<EventDTO> getParticipantEvents(int id) throws EntityDoesNotExistsException {
        try {
            Participant participant = em.find(Participant.class, id);
            if (participant == null) {
                throw new EntityDoesNotExistsException("Participant does not exists.");
            }
            return eventsToDTOs(participant.getEvents());
        } catch (EntityDoesNotExistsException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public List<EventDTO> getResponsibleEvents(int id) throws EntityDoesNotExistsException {
        try {
            Responsible responsible = em.find(Responsible.class, id);
            if (responsible == null) {
                throw new EntityDoesNotExistsException("Responsible does not exists.");
            }
            return eventsToDTOs(responsible.getEvents());
        } catch (EntityDoesNotExistsException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    EventDTO eventToDTO(Event event) {
        return new EventDTO(
                event.getId(),
                event.getDate(),
                event.getName(),
                event.getType(),
                event.getLocal());
    }

    List<EventDTO> eventsToDTOs(List<Event> events) {
        List<EventDTO> dtos = new ArrayList<>();
        for (Event e : events) {
            dtos.add(eventToDTO(e));
        }
        return dtos;
    }

}
