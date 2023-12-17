package soa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private  Long id ;
    @Column(length = 50)
    private String code;
    @Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String Prenom;
    @Column(length = 50)
    private String adresse;
    @Column(length = 50)
    private String tellephone;

    public Client(){};
    public Client(Long id, String code, String nom, String prenom, String adresse, String tellephone, String email) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        Prenom = prenom;
        this.adresse = adresse;
        this.tellephone = tellephone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tellephone='" + tellephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTellephone() {
        return tellephone;
    }

    public void setTellephone(String tellephone) {
        this.tellephone = tellephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(length = 50)
    private String email;

}
