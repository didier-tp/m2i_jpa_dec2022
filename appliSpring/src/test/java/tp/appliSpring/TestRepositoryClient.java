package tp.appliSpring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tp.appliSpring.entity.AdresseClient;
import tp.appliSpring.entity.Client;
import tp.appliSpring.repository.RepositoryAdresseClient;
import tp.appliSpring.repository.RepositoryClient;

@SpringBootTest   //à lancer avec Run as ... / JUnit Test
class TestRepositoryClient {
	
	
	
	@Autowired //equivalent de @Inject	
	private RepositoryClient repositoryClient;
	
	@Autowired //equivalent de @Inject	
	private RepositoryAdresseClient repositoryAdresseClient;
	
	@Test
	void testClientAvecAdresse() {
		
		Client cliXy = new Client(null,"prenomXy" , "nomXy");
		repositoryClient.insertNew(cliXy);
		
		AdresseClient adresseCli = new AdresseClient("rue xy","76000","Rouen",cliXy);
		repositoryAdresseClient.insertNew(adresseCli);
		
		Client client = repositoryClient.findById(cliXy.getId());
		System.out.println("client=" + client);
		System.out.println("adresse du client=" + client.getAdresse());
		
	}

	

}
