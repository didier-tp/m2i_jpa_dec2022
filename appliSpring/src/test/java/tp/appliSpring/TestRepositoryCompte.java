package tp.appliSpring;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tp.appliSpring.entity.Compte;
import tp.appliSpring.entity.Operation;
import tp.appliSpring.repository.RepositoryCompte;
import tp.appliSpring.repository.RepositoryOperation;

@SpringBootTest   //à lancer avec Run as ... / JUnit Test
class TestRepositoryCompte {
	
	@Autowired //equivalent de @Inject	
	private RepositoryCompte repositoryCompte;
	
	@Autowired //equivalent de @Inject	
	private RepositoryOperation repositoryOperation;

	@Test
	void testOperationsDeCompte() {
		Compte compteQueJaime = new Compte(null,"compteFavori" , 999999.99);
		repositoryCompte.insertNew(compteQueJaime);
		Long numCompte = compteQueJaime.getNumero();
		
		//Operation opA = new Operation(null,"achat_a",-5.0,new Date(),compteQueJaime);
		Operation opA = new Operation(null,"achat_a",-5.0); 
		opA.setCompte(compteQueJaime);
		repositoryOperation.insertNew(opA);
		//Operation opB= new Operation(null,"achat_b",-6.0,new Date(),compteQueJaime);
		Operation opB= new Operation(null,"achat_b",-6.0);
		opB.setCompte(compteQueJaime);
		repositoryOperation.insertNew(opB);
		
		//Compte compteRelu = repositoryCompte.findById(numCompte);//avec lazy exception
		Compte compteRelu = repositoryCompte.findWithOperationsById(numCompte);
		List<Operation> operations = compteRelu.getOperations();
		for (Operation op : operations) {
			System.out.println(op);
		}
		Assertions.assertTrue(operations.size()>=1);
	}
	
	//@Test
	void testOperationsDeCompteQuiFonctionnePas() {
		Operation opA = new Operation(null,"achat_a",-5.0,new Date(),null);
		repositoryOperation.insertNew(opA);
		Operation opB= new Operation(null,"achat_b",-6.0,new Date(),null);
		repositoryOperation.insertNew(opB);
		
		Compte compteQueJaime = new Compte(null,"compteFavori" , 999999.99);
		compteQueJaime.getOperations().add(opA);
		compteQueJaime.getOperations().add(opB);
		repositoryCompte.insertNew(compteQueJaime); 
		//on sauvegarde en base ici le coté secondaire (là où il y a mappedBy)
		//ET SANS CASCADE , CA NE FONCTIONNE PAS EN JPA/Hibernate !!!!
		//La clef étrangère est mal sauvegardée en base (reste à NULL)
		
		Long numCompte = compteQueJaime.getNumero();
		
		Compte compteRelu = repositoryCompte.findById(numCompte);
		List<Operation> operations = compteRelu.getOperations();
		for (Operation op : operations) {
			System.out.println(op);
		}
		Assertions.assertTrue(operations.size()>=1);
	}

}
