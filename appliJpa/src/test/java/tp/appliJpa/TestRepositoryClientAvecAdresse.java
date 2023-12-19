package tp.appliJpa;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tp.appliJpa.entity.AdresseClient;
import tp.appliJpa.entity.Client;
import tp.appliJpa.entity.ClientAvecAdresse;
import tp.appliJpa.repository.RepositoryClientAvecAdresse;

@SpringBootTest   //à lancer avec Run as ... / JUnit Test
class TestRepositoryClientAvecAdresse {
	
	@Autowired //equivalent de @Inject	
	private RepositoryClientAvecAdresse repositoryClientAvecAdresse;

	@Test
	void testInsertionEtRelecture() {
		
		
		ClientAvecAdresse cliX1 = new ClientAvecAdresse(null,"prenomX1" , "nomX2");
		
		cliX1.setAdresse(new AdresseClient("45 bis","rue X1" , "80000" , "Amiens"));
		//NB: IMPORTANT .setAdresse() automatically call this.adresse.setClient(this) 
		
		repositoryClientAvecAdresse.insertNew(cliX1);
		Long idCx1 = cliX1.getId();
		Assertions.assertNotNull(idCx1);
		List<ClientAvecAdresse> clients = repositoryClientAvecAdresse.findAll();
		for (ClientAvecAdresse cli : clients) {
			System.out.println(cli);
		}
		Assertions.assertTrue(clients.size()>=1);
		
		ClientAvecAdresse c =  repositoryClientAvecAdresse.findById(idCx1);
		Assertions.assertNotNull(c);
		AdresseClient adr = c.getAdresse(); 
		Assertions.assertEquals("rue X1",adr.getRue());
		System.out.println("adresse du client: " + adr.toString());
	}

}
