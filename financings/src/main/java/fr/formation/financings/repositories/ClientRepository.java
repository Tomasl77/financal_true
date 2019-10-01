package fr.formation.financings.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.financings.dtos.ClientViewDto;
import fr.formation.financings.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    ClientViewDto getById(Long id);

    Page<ClientViewDto> getAllProjectedBy(Pageable pageable);
}
