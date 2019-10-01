package fr.formation.financings.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class Client extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 4, nullable = false)
    private LegalForm legalForm;

    @ManyToOne
    private Contact contact;

    public Client() {
	//
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public LegalForm getLegalForm() {
	return legalForm;
    }

    public void setLegalForm(LegalForm legalForm) {
	this.legalForm = legalForm;
    }

    public Contact getContact() {
	return contact;
    }

    public void setContact(Contact contact) {
	this.contact = contact;
    }
}
