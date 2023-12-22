package tp.appJpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tp.appJpa.entity.Client;
import tp.appJpa.entity.Compte;
import tp.appJpa.entity.Employe;
import tp.appJpa.entity.Operation;
import tp.appJpa.repository.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class TestCompteRepository {

	@Autowired
	private RepositoryCompte repositoryCompte;

	@Autowired
	private RepositoryOperation repositoryOperation;

	@Autowired
	private RepositoryClient repositoryClient;

	@Test
	void testClientAvecComptes() {
		Client cli1 = new Client(null,"Condor" , "Olie");  //mappedBy coté client
		repositoryClient.insertNew(cli1);

		Compte cc1 = new Compte(null,"comptecA",50.0);
		cc1.getClients().add(cli1);  //JoinTable coté compte
		repositoryCompte.insertNew(cc1);

		Compte cc2 = new Compte(null,"comptecB",70.0);
		cc2.getClients().add(cli1);  //JoinTable coté compte
		repositoryCompte.insertNew(cc2);

		//afficher valeurs relues pour vérifier
		Client cli1Relu=repositoryClient.findByIdWithComptes(cli1.getId());
		System.out.println("cli1Relu"+cli1Relu);
		for(Compte c : cli1Relu.getComptes()){
			System.out.println("\t" + c);
		}

		//Solution2:
		System.out.println("via repositoryCompte.findByClientId(idClient):");
		for(Compte c : repositoryCompte.findByClientId(cli1.getId())){
			System.out.println("\t" + c);
		}


	}

	@Test
	void testCompteAvecOperations() {
		Compte c1 = new Compte(null,"compteA",50.0);
		repositoryCompte.insertNew(c1);
		System.out.println("c1.getNumero()=" + c1.getNumero());

		Operation op1C1 = new Operation(null,"achat xxx",-5.6);
		op1C1.setCompte(c1);
		repositoryOperation.insertNew(op1C1);

		Operation op2C1 = new Operation(null,"achat yyy",-45.6);
		op2C1.setCompte(c1);
		repositoryOperation.insertNew(op2C1);

		repositoryCompte.update(c1);



		//relire et afficher le compte 1
		//afficher les operations associées au compte 1
		//Compte c1Relu = repositoryCompte.findById(c1.getNumero());
		Compte c1Relu = repositoryCompte.findWithOperations(c1.getNumero());
		System.out.println("c1Relu="+c1Relu);
		for(Operation op : c1Relu.getOperations()){
			System.out.println("\t op="+op);
		}

		System.out.println("via query sur Operation:");
		for(Operation op : repositoryOperation.findByCompteNumero(c1.getNumero())){
			System.out.println("\t op="+op);
		}
	}

}
