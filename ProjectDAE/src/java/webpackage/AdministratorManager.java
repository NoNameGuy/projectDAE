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
import javax.faces.component.UIComponent;

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

    private AdministratorDTO newAdministrator;
    private AdministratorDTO currentAdministrator;
    private ResponsibleDTO newResponsible;
    private ResponsibleDTO currentResponsible;
    private ParticipantDTO newParticipant;
    private ParticipantDTO currentParticipant;

    private UIComponent component;

    /**
     * Creates a new instance of AdministratorManager
     */
    public AdministratorManager() {
        newAdministrator = new AdministratorDTO();
        newResponsible = new ResponsibleDTO();
        newParticipant = new ParticipantDTO();
    }

    //////////////////////////// Administrator \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public String createAdmininstrator() {

        try {
            administratorBean.createAdmininstrator(
                    newAdministrator.getId(),
                    newAdministrator.getPassword(),
                    newAdministrator.getName(),
                    newAdministrator.getEmail());
            newAdministrator.reset();

            return "AdminPage?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin_user_create?faces-redirect=true";
    }

    public String updateAdministrator() {
        try {
            administratorBean.updateAdministrator(
                    currentAdministrator.getId(),
                    currentAdministrator.getName(),
                    currentAdministrator.getEmail(),
                    currentAdministrator.getPassword());
            return "AdminPage?faces-redirect=true";
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
            responsibleBean.createResponsible(
                    newResponsible.getId(),
                    newResponsible.getPassword(),
                    newResponsible.getName(),
                    newResponsible.getEmail());
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
            participantBean.createParticipant(
                    newParticipant.getId(),
                    newParticipant.getPassword(),
                    newParticipant.getName(),
                    newParticipant.getEmail());
            return "index?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index?faces-redirect=true";
    }

    public List<ParticipantDTO> getAllParticipants() {
        return participantBean.getAllParticipants();

    }

    public AdministratorBean getAdministratorBean() {
        return administratorBean;
    }

    public void setAdministratorBean(AdministratorBean administratorBean) {
        this.administratorBean = administratorBean;
    }

    public ResponsibleBean getResponsibleBean() {
        return responsibleBean;
    }

    public void setResponsibleBean(ResponsibleBean responsibleBean) {
        this.responsibleBean = responsibleBean;
    }

    public ParticipantBean getParticipantBean() {
        return participantBean;
    }

    public void setParticipantBean(ParticipantBean participantBean) {
        this.participantBean = participantBean;
    }

    public AdministratorDTO getNewAdministrator() {
        return newAdministrator;
    }

    public void setNewAdministrator(AdministratorDTO newAdministrator) {
        this.newAdministrator = newAdministrator;
    }

    public AdministratorDTO getCurrentAdministrator() {
        return currentAdministrator;
    }

    public void setCurrentAdministrator(AdministratorDTO currentAdministrator) {
        this.currentAdministrator = currentAdministrator;
    }

    public ResponsibleDTO getNewResponsible() {
        return newResponsible;
    }

    public void setNewResponsible(ResponsibleDTO newResponsible) {
        this.newResponsible = newResponsible;
    }

    public ResponsibleDTO getCurrentResponsible() {
        return currentResponsible;
    }

    public void setCurrentResponsible(ResponsibleDTO currentResponsible) {
        this.currentResponsible = currentResponsible;
    }

    public ParticipantDTO getNewParticipant() {
        return newParticipant;
    }

    public void setNewParticipant(ParticipantDTO newParticipant) {
        this.newParticipant = newParticipant;
    }

    public ParticipantDTO getCurrentParticipant() {
        return currentParticipant;
    }

    public void setCurrentParticipant(ParticipantDTO currentParticipant) {
        this.currentParticipant = currentParticipant;
    }

}
