package tp.appJpa.repository;

import tp.appJpa.entity.Compte;
import tp.appJpa.entity.Operation;

import java.util.List;

public interface RepositoryOperation extends RepositoryGeneric<Operation,Long> {

   List<Operation> findByCompteNumero(long numCpt);
}
