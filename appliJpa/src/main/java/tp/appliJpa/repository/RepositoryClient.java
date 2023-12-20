package tp.appliJpa.repository;

import tp.appliJpa.entity.Client;

public interface RepositoryClient extends RepositoryGeneric<Client,Long>{
   //+ autres méthodes de recherches spécifiques aux clients
	
   Client clientAvecComptes(Long idClient); //2 niveaux (via entityGraph)
   Client clientAvecComptesEtOperations(Long idClient); //3 niveaux (via entityGraph et subGraph)
	
}