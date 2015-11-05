/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpackage;

import ejbs.AdministratorBean;
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
    private AdministratorBean adminBean;
   
    
    private int idAdmin;
    private String passwordAdmin;
    private String nameAdmin;
    private String emailAdmin;

public String createAdmin() {
        
        try{
            adminBean.createAdmin(idAdmin, passwordAdmin, nameAdmin, emailAdmin);
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
    
    
    
    
}
