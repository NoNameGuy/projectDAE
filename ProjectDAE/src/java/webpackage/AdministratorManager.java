/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpackage;

import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import ejbs.AdministratorBean;
import ejbs.ParticipantBean;
import ejbs.ResponsibleBean;
import entity.Administrator;
import entity.Participant;
import entity.Responsible;
import entity.User;
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
    
    private int id;
    private String password;
    private String name;
    private String email;
    private String typeUser;
    private User currentUser;

    /**
     * Creates a new instance of AdministratorManager
     */
    public AdministratorManager() { 
        
    }
    
    public void createUser() {
        System.err.println(typeUser);
        try {
            if ( typeUser == "administrator" ) {
                createAdmin();
            } else if ( typeUser == "responsible" ) {
                createResponsible();
            } else if ( typeUser == "participant" ) {
                
            } else {
                return;
            }
        } catch (Exception e ){
            e.printStackTrace();
        }
        
    }
    
    
    public String updateAdmin() {
        try {
            administratorBean.updateAdmin(
                currentUser.getId(),
                currentUser.getName(),
                currentUser.getEmail(),
                currentUser.getPassword());
            return "index?faces-redirect=true";
        } catch (Exception e) {
            logger.warning("Problem updating user in method updateUser().");
        }
        return "admin_update_user";
    }
    
    public void removeAdmin (ActionEvent event) {
       /* try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteUserId");
            int id = Integer.parseInt(param.getValue().toString());
            administratorBean.removeAdmin(id);
        } catch (Exception e) {
            logger.warning("Problem removing user in method removeUser().");
        }*/
    }
    
    // Administrator
    public AdministratorBean getAdministratorBean() {
        return administratorBean;
    }

    public void setAdministratorBean(AdministratorBean administratorBean) {
        this.administratorBean = administratorBean;
    }
    
    
    public String createAdmin() {
        
        try{
            administratorBean.createAdmin(id, password, name, email);
            return "index?faces-redirect=true";
        } catch(Exception e){
            e.printStackTrace();
        }
        return "index?faces-redirect=true";
    }
    
    
    // Responsible
    public String createResponsible() {
        
        try{
            responsibleBean.createResponsible(id, password, name, email);
            return "index?faces-redirect=true";
        } catch(Exception e){
            e.printStackTrace();
        }
        return "index?faces-redirect=true";
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

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }
    
    
    
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    public List<Administrator> getAllAdministrators() {
        return administratorBean.getAllAdministrators();
        
    }
    
    public List<Responsible> getAllResponsibles() {
        return responsibleBean.getAllResponsibles();
        
    }
    
    public List<Participant> getAllParticipants() {
        return participantBean.getAllParticipants();
        
    }
    
}
