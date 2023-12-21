package tp.appJpa.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tp.appJpa.entity.Employe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //@Component Spring de type Repository/DAO
@Transactional //pour que Spring déclenche automatiquement les commit/rollback
public class RepositoryEmployeJpa extends RepositoryGenericJpa<Employe,Long>
            implements RepositoryEmploye {

    @PersistenceContext()  //pour initialiser le entityManager à partir de la configuration
    //du projet (META-INF/persistence.xml ou bien application.properties ou .yml )
    //ou bien @PersistenceContext(unitName = "appJpa")
    private EntityManager entityManager;

    public RepositoryEmployeJpa() {
        super(Employe.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Employe> findByFirstname(String firstName) {
        /*
        return  entityManager.createQuery("SELECT e FROM Employe e WHERE e.firstname = :firstname", Employe.class)
                        .setParameter("firstname",firstName)
                        .getResultList();
         */
        /*
        return  entityManager.createQuery("SELECT e FROM Employe e WHERE e.firstname = ?1 ", Employe.class)
                .setParameter(1,firstName)
                .getResultList();
         */
        return  entityManager.createNamedQuery("Employe.findByFirstname", Employe.class)
                .setParameter(1,firstName)
                .getResultList();
    }
}
