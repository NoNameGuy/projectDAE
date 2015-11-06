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
@Singleton
@Startup
public class ConfigBean {
    
    @EJB
    AdministratorBean administratorBean;
    @EJB
    ResponsibleBean responsibleBean;
    @EJB
    ParticipantBean participantBean;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   
   @PostConstruct
   public void populateBD() {
       
       try {
           
            // Create Administrator
       
            administratorBean.createAdmin(1, "administrator1", "DAE1", "Admistrator1@DAE.pt");
            administratorBean.createAdmin(2, "administrator2", "DAE2", "Admistrator2@DAE.pt");
            // Create Responsible
            
            participantBean.createParticipant(1, "participant1", "DAE1", "Participant1@DAE.pt");
            participantBean.createParticipant(2, "participant2", "DAE2", "Participant2@DAE.pt");
            // Create Participant
         

            // Create Course
       
       
            // Create Event
       
       
            // Create Subject
            
            
           
       } catch (Exception e){
           
           System.err.println("Error: " + e.getMessage());
           
       }
       

       
       
       
   }
}
