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
    
    /*@ManyToOne
    @JoinColumn(name = "COURSE_CODE")*/
    @NotNull(message="A student must have a course")
    private Course course;
    
    private List<Event> events;
    //@ManyToMany(mappedBy = "participants")
    private List<Subject> subjects;
    
    public Participant() {
        events = new LinkedList<>();
        subjects = new LinkedList<>();
    }

    public Participant(int id, String password, String name, String email, Course course) {
        super(id, password, name, email);
        this.course = course;
        events = new LinkedList<>();
        subjects = new LinkedList<>();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    

}
