/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author paulovieira
 */
@Entity 
@Table(name = "RESPONSIBLE")
public class Responsible extends User implements Serializable {
    
    private List<Event> events;
    
    public Responsible() {
        events = new LinkedList<>();
    }
 
    public Responsible(int id, String password, String name, String email) {
        super(id, password, name, email);
        events = new LinkedList<>();
    }
    



}
