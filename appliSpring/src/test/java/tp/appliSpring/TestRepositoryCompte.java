package tp.appliSpring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tp.appliSpring.entity.Compte;
import tp.appliSpring.entity.Operation;
import tp.appliSpring.repository.RepositoryCompte;

@SpringBootTest   //à lancer avec Run as ... / JUnit Test
class TestRepositoryCompte {
	
	@Autowired //equivalent de @Inject	
	private RepositoryCompte repositoryCompte;

	@Test
	void testOperationsDeCompte() {
		Compte compte1 = repositoryCompte.findById(1L);
		List<Operation> operations = compte1.getOperations();
		for (Operation op : operations) {
			System.out.println(op);
		}
		Assertions.assertTrue(operations.size()>=1);
		
		
	}

}
