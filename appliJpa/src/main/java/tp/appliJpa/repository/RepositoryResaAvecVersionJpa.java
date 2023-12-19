package tp.appliJpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.appliJpa.entity.ResaAvecVersion;

@Repository   
@Transactional 
public class RepositoryResaAvecVersionJpa extends RepositoryGenericJpa<ResaAvecVersion,Long>
                   implements RepositoryResaAvecVersion {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public RepositoryResaAvecVersionJpa() {
		super(ResaAvecVersion.class);
	}

	
}