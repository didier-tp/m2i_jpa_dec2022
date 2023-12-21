package tp.appJpa.repository;

import java.util.List;

public interface RepositoryGeneric<E,ID> {

    E findById(ID id);

    List<E> findAll();

    E insertNew(E e);

    E update(E e);

    void deleteById(ID id);
}
