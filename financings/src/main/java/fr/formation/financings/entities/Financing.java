package fr.formation.financings.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The financing class mapped to the database
 */
@Entity
public class Financing extends AbstractEntity {

    @Column(length = 200, nullable = false) // Column specifications
    private String name;

    @Column(length = 10, nullable = false)
    private String reference;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Double rate;

    // Many Financing to One Client
    // or... One Client to Many Financing
    @ManyToOne
    @JoinColumn(nullable = false)
    private Client client;

    @Column(nullable = false)
    private boolean validated;

    public Financing() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getReference() {
	return reference;
    }

    public void setReference(String reference) {
	this.reference = reference;
    }

    public LocalDate getStartDate() {
	return startDate;
    }

    public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
    }

    public LocalDate getEndDate() {
	return endDate;
    }

    public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
    }

    public Double getAmount() {
	return amount;
    }

    public void setAmount(Double amount) {
	this.amount = amount;
    }

    public Double getRate() {
	return rate;
    }

    public void setRate(Double rate) {
	this.rate = rate;
    }

    public Client getClient() {
	return client;
    }

    public void setClient(Client client) {
	this.client = client;
    }

    public boolean isValidated() {
	return validated;
    }

    public void setValidated(boolean validated) {
	this.validated = validated;
    }
}
