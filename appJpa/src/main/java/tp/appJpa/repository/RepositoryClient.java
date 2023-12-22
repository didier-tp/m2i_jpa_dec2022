package tp.appJpa.repository;

import tp.appJpa.entity.Client;

public interface RepositoryClient extends RepositoryGeneric<Client,Long> {
    Client findByIdWithComptes(Long id);

}
