package tp.appJpa.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tp.appJpa.entity.Client;
import tp.appJpa.entity.Compte;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository //@Component Spring de type Repository/DAO
@Transactional //pour que Spring déclenche automatiquement les commit/rollback
public class RepositoryClientJpa extends RepositoryGenericJpa<Client,Long>
            implements RepositoryClient {

    @PersistenceContext()  //pour initialiser le entityManager à partir de la configuration
    //du projet (META-INF/persistence.xml ou bien application.properties ou .yml )
    //ou bien @PersistenceContext(unitName = "appJpa")
    private EntityManager entityManager;

    public RepositoryClientJpa() {
        super(Client.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public Client findByIdWithComptes(Long id) {
        return entityManager.createNamedQuery("Client.findByIdWithComptes" , Client.class)
                .setParameter(1,id)
                .getSingleResult();
    }
}
