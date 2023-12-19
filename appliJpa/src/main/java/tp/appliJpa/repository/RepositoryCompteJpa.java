package tp.appliJpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.appliJpa.entity.Compte;
import tp.appliJpa.entity.Operation;

@Repository   
@Transactional 
public class RepositoryCompteJpa extends RepositoryGenericJpa<Compte,Long>
                   implements RepositoryCompte {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public RepositoryCompteJpa() {
		super(Compte.class);
	}

	/*
	@Override
	public Compte findWithOperationsById(long numCompte) {
		//PREMIERE VERSION (PAS BIEN!!!!!)
		Compte compte = entityManager.find(Compte.class, numCompte);
		for(Operation op : compte.getOperations()) {
			//boucle for (à vide) pour remonter en mode lazy 
			//les valeurs de la collection operation en mémoire
			//avant que ce ne soit trop tard (avant que EJB ou Spring ferme 
			//automatiquement le entityManager).
		}
		return compte;
	}
	*/
	
	@Override
	public Compte findWithOperationsById(long numCompte) {
		//SECONDE VERSION (BIEN/MIEUX) :  NamedQuery avec mot clef fetch .
		return entityManager.createNamedQuery("Compte.findWithOperationsById", Compte.class)
				            .setParameter("numCompte", numCompte)
				            .getSingleResult();
	}

	@Override
	public List<Compte> findByClientId(long idClient) {
		return entityManager.createNamedQuery("Compte.findByClientId", Compte.class)
	            .setParameter("idClient", idClient)
	            .getResultList();
	}
}