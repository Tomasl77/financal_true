package fr.formation.financings.dtos;

import java.time.LocalDate;

/**
 * An interface representing a view of a {@code Financing}.
 * <p>
 * Exposes getter methods which will be implemented by Spring.
 */
public interface FinancingViewDto {

    /**
     * Returns the id of the financing.
     *
     * @return the id of the financing
     */
    Long getId();

    /**
     * Returns the reference of the financing.
     *
     * @return the reference of the financing
     */
    String getReference();

    /**
     * Returns the start date of the financing.
     *
     * @return the start date of the financing
     */
    LocalDate getStartDate();

    /**
     * Returns the end date of the financing.
     *
     * @return the end date of the financing
     */
    LocalDate getEndDate();

    /**
     * Returns the amount of the financing.
     *
     * @return the amount of the financing
     */
    Double getAmount();

    /**
     * Returns the rate of the financing.
     *
     * @return the rate of the financing
     */
    Double getRate();

    /**
     * Returns the name of the financing's client.
     *
     * @return the name of the financing's client
     */
    String getClientName();

    /**
     * Returns the first name of the financing's client contact.
     *
     * @return the first name of the financing's client contact, or {@code null}
     */
    String getClientContactFirstName();

    /**
     * Returns the last name of the financing's client contact.
     *
     * @return the last name of the financing's client contact, or {@code null}
     */
    String getClientContactLastName();
}
