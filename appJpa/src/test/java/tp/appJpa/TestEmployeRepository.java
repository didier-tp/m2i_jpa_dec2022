package tp.appJpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tp.appJpa.entity.Employe;
import tp.appJpa.repository.RepositoryEmploye;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class TestEmployeRepository {

	@Autowired
	private RepositoryEmploye repositoryEmploye;

	@Test
	void contextInsertionEtRelecture() {
		Employe emp1 = new Employe(null,"prenomQuiVabien","NomQuiVaBien");
		emp1= repositoryEmploye.insertNew(emp1);
		System.out.println("emp1="+emp1);
		assertTrue(emp1.getId()!=null);
		List<Employe> employes = repositoryEmploye.findAll();
		for(Employe emp : employes) {
			System.out.println("emp="+emp);
		}
	}

	@Test
	void testfindByFirstName() {
		Employe emp1 = new Employe(null,"alain","Therieur");
		repositoryEmploye.insertNew(emp1);

		Employe emp2 = new Employe(null,"alex","Therieur");
		repositoryEmploye.insertNew(emp2);

		Employe emp3 = new Employe(null,"alain","Dupond");
		repositoryEmploye.insertNew(emp3);

		List<Employe> employes = repositoryEmploye.findByFirstname("alain");
		for(Employe emp : employes) {
			System.out.println("emp="+emp);
		}
		assertTrue(employes.size()>=2);
	}

}
