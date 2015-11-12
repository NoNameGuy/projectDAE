/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.ParticipantDTO;
import entity.Administrator;
import entity.Participant;
import exceptions.EntityAlreadyExistsException;
import exceptions.EntityDoesNotExistsException;
import exceptions.MyConstraintViolationException;
import exceptions.Utils;
import java.io.Serializable;
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
public class ParticipantBean implements Serializable {
    
    @PersistenceContext(unitName = "ProjectDAEPU")
    private EntityManager em;
    
    //Create Participant

    public void createParticipant(int id, String password, String name, String email)
        throws EntityAlreadyExistsException, MyConstraintViolationException {
        try {
            if(em.find(Participant.class, id) != null){
                throw new EntityAlreadyExistsException("A Participant with that usermane already exists.");
            }
            em.persist(new Participant(id, password, name, email));
        } catch (EntityAlreadyExistsException e) {
            throw e;
        } catch (ConstraintViolationException e) {
            throw new MyConstraintViolationException(Utils.getConstraintViolationMessages(e));  
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    //Participant Update
    
    public void updateParticipant(int id, String password, String name, String email, String role)
            throws EntityDoesNotExistsException, MyConstraintViolationException {
        try {
            Participant participant = em.find(Participant.class, id);
            if (participant == null) {
                throw new EntityDoesNotExistsException("There is no participant with that username.");
            }
            participant.setPassword(password);
            participant.setName(name);
            participant.setEmail(email);
            em.merge(participant);
        } catch (EntityDoesNotExistsException e) {
            throw e;
        } catch (ConstraintViolationException e) {
            throw new MyConstraintViolationException(Utils.getConstraintViolationMessages(e));  
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    //remove Participant
    
    public void removeParticipant(int id)
            throws EntityDoesNotExistsException, MyConstraintViolationException {
        try {
            Participant participant = em.find(Participant.class, id);
            if (participant == null) {
                throw new EntityDoesNotExistsException("There is no participant with that username.");
            }
            em.remove(participant);
        } catch (EntityDoesNotExistsException e) {
            throw e;
        } catch (ConstraintViolationException e) {
            throw new MyConstraintViolationException(Utils.getConstraintViolationMessages(e));  
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    //Verify if participant exists
    
    public boolean existeParticipant(String username) {
        try {
            return em.find(Participant.class, username) != null;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public void listEvents () {
        
    }
    
    public void enrollParticipant () {
        
    }

    public List<ParticipantDTO> getAllParticipants() {
        return em.createNamedQuery("getAllParticipants").getResultList();
    }
}
