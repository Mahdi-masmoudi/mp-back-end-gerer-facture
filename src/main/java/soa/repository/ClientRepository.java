package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.entities.Client;
import soa.entities.Facture;

public interface ClientRepository extends JpaRepository<Client, Long> {
    //public save(Client client);
}
