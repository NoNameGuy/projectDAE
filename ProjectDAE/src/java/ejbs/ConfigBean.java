/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author paulovieira
 */
@Startup
@Singleton
public class ConfigBean {
    
    @EJB
    private AdministratorBean administratorBean;
    @EJB
    private ResponsibleBean responsibleBean;
    @EJB
    private ParticipantBean participantBean;
    @EJB
    private EventBean eventBean;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   
   @PostConstruct
   public void populateBD() {
       
       try {
            // Create Administrator
       
            administratorBean.createAdmin(1, "administrator1", "DAE1", "Admistrator1@DAE.pt");
            administratorBean.createAdmin(2, "administrator2", "DAE2", "Admistrator2@DAE.pt");
            // Create Responsible
            
            participantBean.createParticipant(3, "participant1", "DAE1", "Participant1@DAE.pt", 1);
            participantBean.createParticipant(4, "participant2", "DAE2", "Participant2@DAE.pt", 1);
            // Create Participant
         

            // Create Course
       
       
            // Create Event
            eventBean.createEvent(1, null, "Evento 1", "Aula", "ESTG", 1);
       
            // Create Subject
            
            
           
       } catch (Exception e){
           
           System.err.println("Error: " + e.getMessage());
           
       }
   }
}
