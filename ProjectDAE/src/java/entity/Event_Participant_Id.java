/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Id;

/**
 *
 * @author franc
 */
public class Event_Participant_Id implements Serializable{
    
    @Id
    private int id_event;
    @Id
    private int id_participant;
    
    private boolean presence;

    public Event_Participant_Id() {
    
    }

    public Event_Participant_Id(int id_event, int id_participant, boolean presence) {
        this.id_event = id_event;
        this.id_participant = id_participant;
        this.presence = presence;
    }
    
    
}
