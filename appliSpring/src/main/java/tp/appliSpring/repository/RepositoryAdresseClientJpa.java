package tp.appliSpring.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.appliSpring.entity.AdresseClient;

@Repository   
@Transactional 
public class RepositoryAdresseClientJpa extends RepositoryGenericJpa<AdresseClient,Long>
                   implements RepositoryAdresseClient {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public RepositoryAdresseClientJpa() {
		super(AdresseClient.class);
	}

	
}