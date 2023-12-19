package tp.appliJpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.appliJpa.entity.Client;
import tp.appliJpa.entity.Compte;

@Repository   
@Transactional 
public class RepositoryClientJpa extends RepositoryGenericJpa<Client,Long>
                   implements RepositoryClient {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public RepositoryClientJpa() {
		super(Client.class);
	}

	
}