package tp.appJpa.repository;

import tp.appJpa.entity.Employe;

import java.util.List;

public interface RepositoryEmploye extends RepositoryGeneric<Employe,Long> {
    List<Employe> findByFirstname(String firstName);

}
