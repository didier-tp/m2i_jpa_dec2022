package tp.appliJpa.repository;

import java.util.List;

import tp.appliJpa.entity.Compte;

public interface RepositoryCompte extends RepositoryGeneric<Compte,Long>{
   //+ autres méthodes de recherches spécifiques aux comptes
	
	//variante du findById() qui remonte en plus les operations rattachées au compte
     Compte 	findWithOperationsById(long numCompte);
     
     //retourne tous les comptes d'un client:
     List<Compte> 	findByClientId(long idClient);
	
}