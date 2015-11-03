/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
<<<<<<< HEAD
import java.util.LinkedList;
=======
import javax.ejb.Stateless;
>>>>>>> 7bae0615f32c748eba8b4cc57401122a40dc2a08
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author paulovieira
 */
@Entity
<<<<<<< HEAD
public class Responsible implements Serializable {
    @Id
    private int id;
    private LinkedList<Event> eventList;
    
    public int getId() {
        return id;
    }
=======
public class Responsible extends User implements Serializable {
 
>>>>>>> 7bae0615f32c748eba8b4cc57401122a40dc2a08

    public Responsible(int id, String password, String name, String email) {
        super(id, password, name, email);
    }
    
    public Responsible() {
        
    }


}
