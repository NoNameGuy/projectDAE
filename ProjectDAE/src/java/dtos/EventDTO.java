/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author franc
 */
public class EventDTO implements Serializable {
    
    private int id;
    protected Date date;
    protected String name;
    protected String type;
    protected String local;
    
    public EventDTO() {
        
    }

    public EventDTO(int id, Date date, String name, String type, String local) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.type = type;
        this.local = local;
    }
    
    public void reset(){
        this.id = 0;
        this.date = null;
        this.name = null;
        this.type = null;
        this.type = null;
     
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    
    
    
    
}
