/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;

/**
 *
 * @author franc
 */
public class ResponsibleDTO extends UserDTO implements Serializable {

    public ResponsibleDTO() {
    }

    public ResponsibleDTO(int id, String password, String name, String email) {
        super(id, password, name, email);
    }
    
    
}
