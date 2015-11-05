/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;


/**
 *
 * @author paulovieira
 */
@Entity
public class Participant extends User implements Serializable {
 
    

    public Participant(int id, String password, String name, String email) {
        super(id, password, name, email);
        
    }
    
    public Participant() {
    }
    
    


}
