package tp.appliJpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.appliJpa.entity.ClientAvecAdresse;

@Repository   
@Transactional 
public class RepositoryClientAvecAdresseJpa extends RepositoryGenericJpa<ClientAvecAdresse,Long>
                   implements RepositoryClientAvecAdresse {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public RepositoryClientAvecAdresseJpa() {
		super(ClientAvecAdresse.class);
	}

	
}