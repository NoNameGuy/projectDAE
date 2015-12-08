package entity;

import entity.Participant;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-07T23:13:25")
@StaticMetamodel(Subject.class)
public class Subject_ { 

    public static volatile SingularAttribute<Subject, Integer> courseYear;
    public static volatile SingularAttribute<Subject, String> name;
    public static volatile SingularAttribute<Subject, String> scholarYear;
    public static volatile SingularAttribute<Subject, Integer> id;
    public static volatile ListAttribute<Subject, Participant> participants;

}