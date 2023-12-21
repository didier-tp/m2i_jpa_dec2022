package tp.appJpa.repository;


import tp.appJpa.entity.Employe;

import javax.persistence.EntityManager;
import java.util.List;

/* Version "Sans spring" :
* - pas de @PersistenceContext
* - setEntityManager
* - gestion explicite des transactions entityManager.getTransaction()....
*/
public class RepositoryEmployeJpaSansGeneric implements RepositoryEmployeSansGeneric {


    private EntityManager entityManager;
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public Employe insertNew(Employe emp) {
        try {
            entityManager.getTransaction().begin();
            //en entrée , emp est un nouvel objet employé avec .empId à null (encore inconnu)
            //déclenche automatiquement INSERT INTO Employe(firstname, ....) VALUES(emp.getFirstname() , ....)
            entityManager.persist(emp);//.empId n'est normalement plus null si auto-incr
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("echec insertNew(employe)");
        }
        return emp; //on retourne l'objet modifié (avec .empId non null)
    }

    @Override
    public List<Employe> findAll() {
        return entityManager.createQuery("SELECT e FROM Employe e",Employe.class).getResultList();
    }

    @Override
    public Employe findById(long id) {
        return entityManager.find(Employe.class,id);
    }
}
