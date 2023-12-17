package soa.metier;

import org.springframework.stereotype.Component;
import soa.entities.Facture;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public interface FactureMetierInterface {
    Facture ajoutFacture(Facture factureDTO);
    List<Facture> listeFactures();
    void modifierFacture(Facture facture);
    void supprimerFacture(long numfac);
    double sommePrix(double sommePrix);
    void donnerDate(Date date );

    Optional<Facture> findById(long numfac);
    List<Facture> findAll();

}
