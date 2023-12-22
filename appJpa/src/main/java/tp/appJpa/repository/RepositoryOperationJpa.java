package tp.appJpa.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tp.appJpa.entity.Compte;
import tp.appJpa.entity.Employe;
import tp.appJpa.entity.Operation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //@Component Spring de type Repository/DAO
@Transactional //pour que Spring déclenche automatiquement les commit/rollback
public class RepositoryOperationJpa extends RepositoryGenericJpa<Operation,Long>
            implements RepositoryOperation {

    @PersistenceContext()  //pour initialiser le entityManager à partir de la configuration
    //du projet (META-INF/persistence.xml ou bien application.properties ou .yml )
    //ou bien @PersistenceContext(unitName = "appJpa")
    private EntityManager entityManager;

    public RepositoryOperationJpa() {
        super(Operation.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Operation> findByCompteNumero(long numCpt) {
        return  entityManager.createNamedQuery("Operation.findByCompteNumero", Operation.class)
                .setParameter(1,numCpt)
                .getResultList();
    }
}
