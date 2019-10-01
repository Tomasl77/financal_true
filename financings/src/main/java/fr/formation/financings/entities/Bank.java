package fr.formation.financings.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Bank extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String city;

    @Column(length = 255, nullable = false)
    private String adress;

    @Column(length = 5, nullable = false)
    private String zipcode;

    @Column(length = 14, nullable = false)
    private String siret;

    public Bank() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getAdress() {
	return adress;
    }

    public void setAdress(String adress) {
	this.adress = adress;
    }

    public String getZipcode() {
	return zipcode;
    }

    public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
    }

    public String getSiret() {
	return siret;
    }

    public void setSiret(String siret) {
	this.siret = siret;
    }
}
