package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.entities.Devise;
import soa.entities.Facture;

public interface DeviseRepository extends JpaRepository<Devise, Long> {
}
