package fr.formation.financings.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Contact extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String firstName;

    @Column(length = 255, nullable = false)
    private String lastName;

    @Embedded
    private ContactInfo info;

    public Contact() {
	//
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public ContactInfo getInfo() {
	return info;
    }

    public void setInfo(ContactInfo info) {
	this.info = info;
    }
}
