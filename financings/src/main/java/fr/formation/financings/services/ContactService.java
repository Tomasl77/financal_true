package fr.formation.financings.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.formation.financings.dtos.ContactDto;
import fr.formation.financings.dtos.ContactViewDto;

public interface ContactService {

    void create(ContactDto dto);

    void update(Long id, ContactDto dto);

    void delete(Long id);

    ContactViewDto getOne(Long id);

    Page<ContactViewDto> getAll(Pageable pageable);
}
