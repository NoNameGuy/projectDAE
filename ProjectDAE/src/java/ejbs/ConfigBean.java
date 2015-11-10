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
    @EJB
    private SubjectBean subjectBean;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   
   @PostConstruct
   public void populateBD() {
       
       try {
            // Create Administrator
            administratorBean.createAdmin(1, "administrator1", "DAE1", "Admistrator1@DAE.pt");
            administratorBean.createAdmin(2, "administrator2", "DAE2", "Admistrator2@DAE.pt");
            
            // Create Responsible
            responsibleBean.createResponsible(3, "responsible1", "DAE1", "Responsible1@DAE.pt");
            responsibleBean.createResponsible(4, "responsible2", "DAE2", "Responsible2@DAE.pt");
            
            // Create Participant
            participantBean.createParticipant(5, "participant1", "DAE1", "Participant1@DAE.pt");
            participantBean.createParticipant(6, "participant2", "DAE2", "Participant2@DAE.pt");
         
            // Create Event
            eventBean.createEvent(1, null, "Evento 1", "Aula", "ESTG", 3);
            eventBean.createEvent(2, null, "Evento 2", "Aula", "ESTG", 4);
            
            // Create Subject
            subjectBean.createSubject(1L, "IEI", 1, "2015/2016");
            subjectBean.createSubject(2L, "TC", 1, "2015/2016");
            subjectBean.createSubject(3L, "PA", 2, "2015/2016");
            subjectBean.createSubject(4L, "DAE", 3, "2015/2016");
            subjectBean.createSubject(5L, "DAD", 3, "2015/2016");
            
            
            
       } catch (Exception e){
           
           System.err.println("Error: " + e.getMessage());
           
       }
   }
}
