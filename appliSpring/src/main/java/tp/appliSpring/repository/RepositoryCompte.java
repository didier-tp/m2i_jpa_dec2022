package tp.appliSpring.repository;

import tp.appliSpring.entity.Compte;

public interface RepositoryCompte extends RepositoryGeneric<Compte,Long>{
   //+ autres méthodes de recherches spécifiques aux employés
	
	//variante du findById() qui remonte en plus les operations rattachées au compte
     Compte 	findWithOperationsById(long numCompte);
     
	
}