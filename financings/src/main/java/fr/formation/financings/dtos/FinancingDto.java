package fr.formation.financings.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class FinancingDto {

    @NotEmpty
    @Size(max = 200)
    private String name;

    @NotEmpty
    @Size(max = 10)
    private String reference;

    @NotNull
    @PastOrPresent
    private LocalDate startDate;

    @NotNull
    @Future
    private LocalDate endDate;

    @NotNull
    @Positive
    private Double amount;

    @NotNull
    @Positive
    private Double rate;

    @NotNull
    private Long clientId;

    public FinancingDto() {
	//
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

    public Long getClientId() {
	return clientId;
    }

    public void setClientId(Long clientId) {
	this.clientId = clientId;
    }
}
