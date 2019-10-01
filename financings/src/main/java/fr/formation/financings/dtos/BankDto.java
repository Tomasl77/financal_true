package fr.formation.financings.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BankDto {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String city;

    @NotBlank
    @Size(max = 255)
    private String adress;

    @NotNull
    @Size(max = 5)
    private String zipcode;

    @NotBlank
    @Size(max = 14)
    private String siret;

    public BankDto() {
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
