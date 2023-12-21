package tp.appJpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tp.appJpa.entity.Compte;
import tp.appJpa.entity.Employe;
import tp.appJpa.entity.Operation;
import tp.appJpa.repository.RepositoryCompte;
import tp.appJpa.repository.RepositoryEmploye;
import tp.appJpa.repository.RepositoryOperation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class TestCompteRepository {

	@Autowired
	private RepositoryCompte repositoryCompte;

	@Autowired
	private RepositoryOperation repositoryOperation;


	@Test
	void testCompteAvecOperations() {
		Compte c1 = new Compte(null,"compteA",50.0);
		repositoryCompte.insertNew(c1);

		Operation op1C1 = new Operation(null,"achat xxx",-5.6);
		op1C1.setCompte(c1);
		repositoryOperation.insertNew(op1C1);

		Operation op2C1 = new Operation(null,"achat yyy",-45.6);
		op2C1.setCompte(c1);
		repositoryOperation.insertNew(op2C1);


		//relire et afficher le compte 1
		//afficher les operations associées au compte 1
		Compte c1Relu = repositoryCompte.findById(c1.getNumero());
		System.out.println("c1Relu="+c1Relu);
		for(Operation op : c1Relu.getOperations()){
			System.out.println("\t op="+op);
		}
	}

}
