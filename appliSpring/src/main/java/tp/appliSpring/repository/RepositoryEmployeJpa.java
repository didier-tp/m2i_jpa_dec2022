package tp.appliSpring.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.appliSpring.entity.Employe;

@Repository   //ou bier @Stateless sur projet EJB
@Transactional //ou rien sur projet EJB car par défaut @TransactionManagement(CONTAINER)
               //et TransactionAttribute(REQUIRED)
public class RepositoryEmployeJpa extends RepositoryGenericJpa<Employe,Long>
                   implements RepositoryEmploye {
	
	@PersistenceContext
	private EntityManager entityManager;
	
   

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}



	public RepositoryEmployeJpa() {
		super(Employe.class);
	}

}