package tp.appJpa.repository;

import tp.appJpa.entity.Employe;

import java.util.List;

public interface RepositoryEmployeSansGeneric {
    Employe insertNew(Employe e);
    List<Employe> findAll();
    Employe findById(long id);

    //...
}
