package tp.appliJpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.appliJpa.entity.BigData;

@Repository   
@Transactional 
public class RepositoryBigDataJpa extends RepositoryGenericJpa<BigData,Long>
                   implements RepositoryBigData {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public RepositoryBigDataJpa() {
		super(BigData.class);
	}

	
}