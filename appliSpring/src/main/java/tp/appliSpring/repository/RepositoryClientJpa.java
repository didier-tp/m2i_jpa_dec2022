package tp.appliSpring.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.appliSpring.entity.Client;
import tp.appliSpring.entity.Compte;

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