/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpackage;

import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import dtos.AdministratorDTO;
import dtos.ParticipantDTO;
import dtos.ResponsibleDTO;
import ejbs.AdministratorBean;
import ejbs.ParticipantBean;
import ejbs.ResponsibleBean;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author paulovieira
 */
@ManagedBean
@SessionScoped
public class AdministratorManager {

    @EJB
    private AdministratorBean administratorBean;
    @EJB
    private ResponsibleBean responsibleBean;
    @EJB
    private ParticipantBean participantBean;

    private AdministratorDTO newAdministator;
    private AdministratorDTO currentAdministator;
    private ResponsibleDTO newResponsible;
    private ResponsibleDTO currentResponsible;
    private ParticipantDTO newParticipant;
    private ParticipantDTO currentParticipant;

    private int id;
    private String password;
    private String name;
    private String email;

    /**
     * Creates a new instance of AdministratorManager
     */
    public AdministratorManager() {
        newAdministator = new AdministratorDTO();
        newResponsible = new ResponsibleDTO();
        newParticipant = new ParticipantDTO();
    }

    //////////////////////////// Administrator \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public String createAdmininstrator() {

        try {
            administratorBean.createAdmininstrator(id, password, name, email);
            return "index?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index?faces-redirect=true";
    }

    public String updateAdministrator() {
        try {
            administratorBean.updateAdministrator(
                    currentAdministator.getId(),
                    currentAdministator.getName(),
                    currentAdministator.getEmail(),
                    currentAdministator.getPassword());
            return "index?faces-redirect=true";
        } catch (Exception e) {
            logger.warning("Problem updating user in method updateUser().");
        }
        return "admin_update_user";
    }

    public void removeAdministrator(ActionEvent event) {
        /*try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteUserId");
            int id = Integer.parseInt(param.getValue().toString());
            administratorBean.removeAdministrator(id);
        } catch (Exception e) {
            logger.warning("Problem removing user in method removeUser().");
        }*/
    }
    
        public List<AdministratorDTO> getAllAdministrators() {
        return administratorBean.getAllAdministrators();
    }

    //////////////////////////// Responsible \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public String createResponsible() {

        try {
            responsibleBean.createResponsible(id, password, name, email);
            return "index?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index?faces-redirect=true";
    }

    public List<ResponsibleDTO> getAllResponsibles() {
        return responsibleBean.getAllResponsibles();
    }

    //////////////////////////// Participant \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public String createParticipant() {

        try {
            participantBean.createParticipant(id, password, name, email);
            return "index?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index?faces-redirect=true";
    }

    public List<ParticipantDTO> getAllParticipants() {
        return participantBean.getAllParticipants();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
