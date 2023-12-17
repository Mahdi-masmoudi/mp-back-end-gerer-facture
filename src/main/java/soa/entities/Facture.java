package soa.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity

public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numfac;

    @Temporal(TemporalType.DATE)
    private Date datefac;

    private double somprix;



    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    private Client client;
    @ManyToOne (cascade= {CascadeType.MERGE})
    private Devise devise;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Produit> produits = new ArrayList<Produit>();

    @Override
    public String toString() {
        return "Facture{" +
                "numfac=" + numfac +
                ", datefac=" + datefac +
                ", somprix=" + somprix +
                ", client=" + client +
                ", devise=" + devise +
                ", produits=" + produits +
                '}';
    }
    public Facture() {
    }

    public Facture(int numfac, Date datefac, double somprix, Client client, Devise devise,List<Produit> produit) {
        this.numfac = numfac;
        this.datefac = datefac;
        this.somprix = somprix;
        this.client = client;
        this.devise = devise;
        this.produits = produit;

    }
    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
    public int getNumfac() {
        return numfac;
    }

    public void setNumfac(int numfac) {
        this.numfac = numfac;
    }

    public Date getDatefac() {
        return datefac;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatefac(Date datefac) {
        this.datefac = datefac;
    }

    public double getSomprix() {
        return somprix;
    }

    public void setSomprix(double somprix) {
        this.somprix = somprix;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Facture(List<Produit> produits) {
        this.produits = produits;
    }
}
