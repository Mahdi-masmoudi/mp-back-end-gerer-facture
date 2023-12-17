package soa.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.entities.Facture;
import soa.entities.Produit;
import soa.repository.FactureRepository;
import soa.repository.ProduitRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FactureMetierImpl implements  FactureMetierInterface{

    @Autowired
    FactureRepository factureRepository;

    @Autowired
    ProduitRepository prodRepository;
    @Override
    public Facture ajoutFacture(Facture facture) {

        Facture nf = new Facture();
        nf.setNumfac(facture.getNumfac());
        nf.setClient(facture.getClient());
        nf.setDatefac(facture.getDatefac());
        nf.setDevise(facture.getDevise());
        nf.setSomprix(facture.getSomprix());

      nf=  factureRepository.save(nf);

        // ajouter les produits

        for (Produit p : facture.getProduits())
        {   Produit fp=null;
            if (p.getId()!=null) {
                System.out.println("old...");
                 fp = prodRepository.findById(p.getId()).get();
            }
            else
            {
                System.out.println("new...");
               fp=prodRepository.save(p) ;
            }
            nf.getProduits().add(fp);
        }

        factureRepository.save(nf);

      /*

        // Assuming you want to generate a new ID (if not provided)
        if (facture.getId() == null) {
            facture.setId(generateNewFactureId());
        }

        // You may want to perform additional validation or business logic here

        factureRepository.save(facture);

       */
        return nf;
    }

    private Long generateNewFactureId() {
        return new Random().nextLong();

    }

    @Override
    public List<Facture> listeFactures() {
        return factureRepository.findAll();
    }

    @Override
    public void modifierFacture(Facture updatedFacture) {
        Optional<Facture> existingFacture = factureRepository.findById(updatedFacture.getId());
        if (existingFacture.isPresent()) {
            Facture factureToUpdate = existingFacture.get();
            // Update other fields of factureToUpdate based on updatedFacture
            factureToUpdate.setNumfac(updatedFacture.getNumfac());
            factureToUpdate.setDatefac(updatedFacture.getDatefac());
            factureToUpdate.setSomprix(updatedFacture.getSomprix());
            factureToUpdate.setClient(updatedFacture.getClient());
            factureToUpdate.setDevise(updatedFacture.getDevise());
            factureToUpdate.setProduits(updatedFacture.getProduits());

            factureRepository.save(factureToUpdate);
        } else {
            throw new IllegalArgumentException("La facture avec le numéro " + updatedFacture.getId() + " n'existe pas.");
        }
    }


    @Override
    public void supprimerFacture(long numfac) {
    factureRepository.deleteById(numfac);
    }

    @Override
    public double sommePrix(double sommePrix) {

        return 0;
    }

    @Override
    public void donnerDate(Date date) {

    }

    @Override
    public Optional<Facture> findById(long numfac) {

        return factureRepository.findById(numfac);
    }

    @Override
    public List<Facture> findAll() {
        return factureRepository.findAll();
    }
}
