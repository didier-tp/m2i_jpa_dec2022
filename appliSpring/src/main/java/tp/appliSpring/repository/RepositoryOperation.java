package tp.appliSpring.repository;

import java.util.List;

import tp.appliSpring.entity.Operation;

public interface RepositoryOperation extends RepositoryGeneric<Operation,Long>{
   //+ autres méthodes de recherches spécifiques aux operations
	
	List<Operation> findOperationsByNumCompte(long numCompte);
	
}