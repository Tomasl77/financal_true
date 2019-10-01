package fr.formation.financings.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.formation.financings.dtos.ClientDto;
import fr.formation.financings.dtos.ClientViewDto;

public interface ClientService {

    void create(ClientDto dto);

    void update(Long id, ClientDto dto);

    void delete(Long id);

    ClientViewDto getOne(Long id);

    Page<ClientViewDto> getAll(Pageable pageable);
}
