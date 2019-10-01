package fr.formation.financings.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.financings.dtos.ContactViewDto;
import fr.formation.financings.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    ContactViewDto getById(Long id);

    /**
     * Returns a {@code Page} of {@code ContactViewDto} with given paging
     * information.
     * 
     * @param pageable paging information
     * @return a {@code Page} of {@code ContactViewDto}
     */
    Page<ContactViewDto> getAllProjectedBy(Pageable pageable);
}
