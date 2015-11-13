/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpackage;

import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import dtos.EventDTO;
import ejbs.EventBean;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

/**
 *
 * @author UTIL
 */
@ManagedBean
@SessionScoped
public class EventManager {

    @EJB
    private EventBean eventBean;

    private int id;
    protected Date date;
    protected String name;
    protected String type;
    protected String local;
    //protected List<Participant> participants; //lista de participantes necessaria?
    protected int responsible;

    public EventManager() {
    }

    public String createEvent() {

        try {
            eventBean.createEvent(id, date, name, type, local, responsible);
            return "index?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index?faces-redirect=true";
    }

    public void removeEvent(ActionEvent event) {
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("eventID");
            int id = Integer.parseInt(param.getValue().toString());
            eventBean.removeEvent(id);
        } catch (Exception e) {
            logger.warning("Problem removing user in method removeUser().");
        }
    }

    public EventBean getEventBean() {
        return eventBean;
    }

    public void setEventBean(EventBean eventBean) {
        this.eventBean = eventBean;
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

    public int getResponsible() {
        return responsible;
    }

    public void setResponsible(int responsible) {
        this.responsible = responsible;
    }

    public List<EventDTO> getAllEvents() {
        return eventBean.getAllEvents();
    }
}
