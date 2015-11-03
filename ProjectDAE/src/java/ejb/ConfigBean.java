/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
}
