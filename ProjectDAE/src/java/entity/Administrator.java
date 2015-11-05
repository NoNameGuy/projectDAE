/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author paulovieira
 */
@Entity
public class Administrator extends User implements Serializable {

    public Administrator(int id, String password, String name, String email) {
        super(id, password, name, email);
    }
    
    public Administrator() {
        
    }
}
