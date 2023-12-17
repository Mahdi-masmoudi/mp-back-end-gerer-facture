package soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import soa.entities.*;
import soa.metier.FactureMetierInterface;
import soa.repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class SpringJpaApplication3 {


    // Add @Autowired annotation


    static FactureMetierInterface factureMetier;


    // Declaration of Repository objects
    static FactureRepository factureRepository;
    static DeviseRepository deviseRepository;
    static ClientRepository clientRepository;
    static ProduitRepository produitRepository;

    public static void main(String[] args) {
        System.out.println("---------Startup----------");

        // Dependency injection for Repository objects
        ApplicationContext context = SpringApplication.run(SpringJpaApplication3.class, args);
        factureRepository = context.getBean(FactureRepository.class);
        clientRepository = context.getBean(ClientRepository.class);
        produitRepository = context.getBean(ProduitRepository.class);
        deviseRepository = context.getBean(DeviseRepository.class);
        factureMetier = context.getBean(FactureMetierInterface.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;

        try {
            date1 = sdf.parse("2023-04-15");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //create devise
        System.out.println("---------Create a Devise----------");
        Devise devise = new Devise(1L,"code","symbol",2.02);
        Devise devise0 = new Devise(1L,"code","symbol",2.02);
        deviseRepository.save(devise);




        // Create a client
        System.out.println("---------Create a Client----------");
        Client client = new Client(1L, "Doe","sabri","jammoussi","tanyour","23734344","sabrijm123@gmail.com");
        clientRepository.save(client);

        // Create some products
        System.out.println("---------Create Products----------");
        Produit produit1 = new Produit("Laptop","https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RW16TLT?ver=99ac&q=90&m=6&h=705&w=1253&b=%23FFFFFFFF&f=jpg&o=f&p=140&aim=true", 1200, 20, date1);
        Produit produit2 = new Produit("Printer","https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RW16TLT?ver=99ac&q=90&m=6&h=705&w=1253&b=%23FFFFFFFF&f=jpg&o=f&p=140&aim=true", 300, 15, date1);
        Produit produit3 = new Produit("hp","https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RW16TLT?ver=99ac&q=90&m=6&h=705&w=1253&b=%23FFFFFFFF&f=jpg&o=f&p=140&aim=true", 1500, 10, date1);
        Produit produit4 = new Produit("MSI","https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RW16TLT?ver=99ac&q=90&m=6&h=705&w=1253&b=%23FFFFFFFF&f=jpg&o=f&p=140&aim=true", 2000, 30, date1);
        Produit produit5 = new Produit("ASUS","https://spacenet.tn/40248-large_default/pc-portable-asus-s509ja-i3-10e-gen-20go-1to-gris.jpg", 2500, 5, date1);

        // Create a list of produits
        List<Produit> produits1 = new ArrayList<>();
        produits1.add(produit2);
        produits1.add(produit3);
        produits1.add(produit4);
        List<Produit> produits2 = new ArrayList<>();
        produits2.add(produit1);
        produits2.add(produit5);
        Facture facture = new Facture(12, date1, 200.0, client, devise,produits1);
        Facture facture2 = new Facture(200,date1, 45800.0,client,devise,produits2);

// Remove or update the 'id' field, let the database generate a new one
       // facture.setId(null);
       // factureMetier.ajoutFacture(facture);
        facture.setClient(client);


        facture2.setClient(client);
        facture.setDevise(devise);
        facture.setProduits(produits1);
        facture.setProduits(produits2);
        // Add @Transactional annotation if needed
        factureMetier.ajoutFacture(facture);
        factureMetier.ajoutFacture(facture2);
        //factureMetier.supprimerFacture(1);
    //modifier
        //factureMetier.modifierFacture(facture);
        // Display all factures
        // afficherToutesLesFactures();

        // Add a new product to an existing facture
       System.out.println("---------Add a new Product to an existing Facture----------");
        Produit newProduct = new Produit("Yaourt","https://courses.monoprix.tn/carthage/155574-large_default/yaourt-aromatis%C3%A9.jpg", 0.400, 20, date1);
        produitRepository.save(newProduct);
        facture.getProduits().add(newProduct);
    }


}
