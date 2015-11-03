/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author paulovieira
 */
@Entity
public class Responsible {
    @Id
    private int id;
    private LinkedList<Event> eventList;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
