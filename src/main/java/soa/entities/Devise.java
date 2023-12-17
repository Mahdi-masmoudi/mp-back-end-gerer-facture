package soa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Devise {
    @Id
    @GeneratedValue
    private  Long id ;
    @Column(length = 50)
    private String code;
    @Column(length = 50)
    private String symbol;
    private  double taux;

    @Override
    public String toString() {
        return "Devise{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", symbol='" + symbol + '\'' +
                ", taux=" + taux +
                '}';
    }

    public Devise(){};

    public Devise(Long id, String code, String symbol, double taux) {
        this.id = id;
        this.code = code;
        this.symbol = symbol;
        this.taux = taux;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
