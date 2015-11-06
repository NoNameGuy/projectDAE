/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 *
 * @author paulovieira
 */
@Entity
@Table(name = "PARTICIPANTS")
    @NamedQueries({
        @NamedQuery(name = "getAllParticipants",
                query = "SELECT p FROM Participant p ORDER BY p.name")
    })
public class Participant extends User implements Serializable {
 
    

    public Participant(int id, String password, String name, String email) {
        super(id, password, name, email);
        
    }
    
    public Participant() {
    }
    
    


}
