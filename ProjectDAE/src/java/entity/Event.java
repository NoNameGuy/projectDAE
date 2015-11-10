/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author paulovieira
 */
@Entity
@Table(name = "EVENT")
@NamedQueries({
    @NamedQuery(name = "getAllEvents",
            query = "SELECT e FROM Event e ORDER BY e.date")
    })
public class Event {
    @Id
    private int id;
    @Temporal(TemporalType.DATE)
    protected Date date;
    @NotNull
    protected String name;
    protected String type;
    protected String local;
    protected List<Participant> participants;
    protected Responsible responsible;
   
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public Event() {
        this.participants = new LinkedList<Participant>();
    }

    public Event(int id, Date date, String name, String type, String local, Responsible responsible) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.type = type;
        this.local = local;
        this.participants = new LinkedList<Participant>();
        this.responsible = responsible;
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

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
    
    public void addParticipant(Participant participant) {
        participants.add(participant);
    }
    
    public void removeParticipant(Participant participant) {
        participants.remove(participant);
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }
 
}
