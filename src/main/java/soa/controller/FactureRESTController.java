package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.entities.Facture;
import soa.entities.Produit;
import soa.metier.FactureMetierInterface;
import soa.repository.FactureRepository;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Factures")
public class FactureRESTController {
    @Autowired
    private FactureRepository factureRepository;
    @Autowired
    private FactureMetierInterface factureMetier;
    @GetMapping(value ="/index" )
    public String accueil() {
        return "BienVenue au service Web REST 'factures'.....";
    }
    @GetMapping("/")
    public List<Facture> listeFacture() {
        return factureRepository.findAll();
    }
    @GetMapping("/{id}")
    public Facture detailsFacture(@PathVariable Long id) {
        return factureRepository.findById(id).orElse(null);
    }
    @GetMapping("client/{client}")
    public List<Facture> getFacturesByClient(@PathVariable Long client) {
        // Assuming you have a method in your repository to find Factures by client ID
        return factureRepository.findByClient_Id(client);
    }
    @DeleteMapping(value = "delete/{id}")
    public String deleteFacture(@PathVariable Long id){
         factureRepository.deleteById(id);
            return "Deleted !!";
    }
    @PostMapping(value = "/add")
    public Facture ajoutFacture(@RequestBody Facture facture) {
        System.out.println("Facture:"+facture);

        return factureMetier.ajoutFacture(facture);
    }
    @PutMapping(value = "/")
    public  Facture updateFacture(@RequestBody Facture f ){
        return factureRepository.save(f);

    }
//    @DeleteMapping(value = "/{id}")
//    public  String   deleteFacture(@RequestBody Facture f ){
//        factureRepository.delete(f);
//        return "Deleted";
//    }
}
