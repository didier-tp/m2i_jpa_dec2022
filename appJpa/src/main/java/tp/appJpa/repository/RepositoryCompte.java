package tp.appJpa.repository;

import tp.appJpa.entity.Compte;
import tp.appJpa.entity.Employe;

import java.util.List;

public interface RepositoryCompte extends RepositoryGeneric<Compte,Long> {
    Compte findWithOperations(long numCompte);

}
