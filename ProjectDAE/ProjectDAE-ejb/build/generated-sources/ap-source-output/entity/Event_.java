package entity;

import entity.Participant;
import entity.Responsible;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-07T23:13:25")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Date> date;
    public static volatile SingularAttribute<Event, Boolean> openInscriptions;
    public static volatile SingularAttribute<Event, Responsible> responsible;
    public static volatile SingularAttribute<Event, String> name;
    public static volatile SingularAttribute<Event, Integer> id;
    public static volatile SingularAttribute<Event, String> type;
    public static volatile SingularAttribute<Event, String> local;
    public static volatile ListAttribute<Event, Participant> participants;

}