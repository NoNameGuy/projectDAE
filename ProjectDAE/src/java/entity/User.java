/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author paulovieira
 */
@Entity
public class User {
    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
