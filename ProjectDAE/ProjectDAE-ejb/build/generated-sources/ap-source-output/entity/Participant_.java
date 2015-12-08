package entity;

import entity.Event;
import entity.Subject;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-07T23:13:25")
@StaticMetamodel(Participant.class)
public class Participant_ extends User_ {

    public static volatile ListAttribute<Participant, Subject> subjects;
    public static volatile ListAttribute<Participant, Event> events;

}