/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpackage;

import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import ejbs.AdministratorBean;
import entity.User;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;

/**
 *
 * @author paulovieira
 */
@ManagedBean
@SessionScoped
public class AdministratorManager {

    @EJB
    private AdministratorBean adminBean;
   
    
    private int idAdmin;
    private String passwordAdmin;
    private String username;
    private String nameAdmin;
    private String emailAdmin;
    private User currentUser;

    
    
    
public String createAdmin() {
        
        try{
            adminBean.createAdmin(idAdmin, username, passwordAdmin, nameAdmin, emailAdmin);
            return "index?faces-redirect=true";
        } catch(Exception e){
            e.printStackTrace();
        }
        return "index?faces-redirect=true";
    }
    /**
     * Creates a new instance of AdministratorManager
     */
    public AdministratorManager() {
        
        
        
    }
    
    public String updateAdmin() {
        try {
            adminBean.updateAdmin(
                currentUser.getId(),
                currentUser.getUsername(),
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
            adminBean.removeAdmin(id);
        } catch (Exception e) {
            logger.warning("Problem removing user in method removeUser().");
        }*/
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AdministratorBean getAdminBean() {
        return adminBean;
    }

    public void setAdminBean(AdministratorBean adminBean) {
        this.adminBean = adminBean;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public String getNameAdmin() {
        return nameAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }
    
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    public List<User> getAllUsers() {
        return adminBean.getAll();
    }
    
}
