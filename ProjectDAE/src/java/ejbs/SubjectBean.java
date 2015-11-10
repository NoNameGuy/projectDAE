/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entity.Subject;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author franc
 */
@Stateless
public class SubjectBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "ProjectDAEPU")
    private EntityManager em;

    public void createSubject(Long id, String name, int courseYear, String scholarYear) {
        try {
            if (em.find(SubjectBean.class, id) != null) {
                return;
            }
            Subject subject = new Subject(id, name, courseYear, scholarYear);
            em.persist(subject);
            
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
   
}
