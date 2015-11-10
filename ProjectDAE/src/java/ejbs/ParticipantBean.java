/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entity.Participant;
import java.io.Serializable;
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
public class ParticipantBean implements Serializable {
    
    @PersistenceContext(unitName = "ProjectDAEPU")
    private EntityManager em;
    
    //Create Participant

    public void createParticipant(int id, String password, String name, String email) {

        try {
            if(em.find(Participant.class, id) != null){
                return;
            }
            Participant participant = new Participant(id, password, name, email);
            em.persist(participant);

        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }

    }

    //Participant Update
    
    public void updateParticipant(int id, String password, String name, String email, String role) {
        try {
            Participant participant = em.find(Participant.class, id);
            if (participant == null) {
                return;
            }
            participant.setPassword(password);
            participant.setName(name);
            participant.setEmail(email);
            //participant.setRole(role);
            em.merge(participant);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    //remove Participant
    
    public void removeParticipant(int id) {
        try {
            Participant participant = em.find(Participant.class, id);
            em.remove(participant);
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

    public List<Participant> getAllParticipants() {
        return em.createNamedQuery("getAllParticipants").getResultList();
    }
}
