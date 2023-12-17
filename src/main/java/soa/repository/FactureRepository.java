package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import soa.entities.Facture;

import java.util.Date;
import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    List<Facture> findByClient_Id(Long client);
}