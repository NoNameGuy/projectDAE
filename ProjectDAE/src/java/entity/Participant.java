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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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

    @ManyToMany(mappedBy = "participants")
    private List<Event> events;
    
    @ManyToMany(mappedBy = "participants")
    private List<Subject> subjects;
    
    public Participant() {
        events = new LinkedList<>();
        subjects = new LinkedList<>();
    }

    public Participant(int id, String password, String name, String email) {
        super(id, password, name, email);
        events = new LinkedList<>();
        subjects = new LinkedList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
    public void addEvent(Event event) {
        events.add(event);
    }
    
    public void removeEvent(Event event) {
        events.remove(event);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    

}
