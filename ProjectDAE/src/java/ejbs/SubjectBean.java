/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entity.Subject;
import exceptions.EntityAlreadyExistsException;
import exceptions.EntityDoesNotExistsException;
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

    public void createSubject(Long id, String name, int courseYear, String scholarYear)
        throws EntityAlreadyExistsException {
        try {
            if (em.find(Subject.class, id) != null) {
                throw new EntityAlreadyExistsException("A subject with that id already exists.");
            }
            Subject subject = new Subject(id, name, courseYear, scholarYear);
            em.persist(subject);
            
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
   
}
