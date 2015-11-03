/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author UTIL
 */
@Stateless
public class ParticipantBean implements Serializable {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public void listEvents () {
        
    }
    
    public void enrollInEvent () {
        
    }
}
