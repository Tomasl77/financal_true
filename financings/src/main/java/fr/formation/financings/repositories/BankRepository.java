package fr.formation.financings.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.financings.dtos.BankViewDto;
import fr.formation.financings.entities.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

    BankViewDto getById(Long id);

    Page<BankViewDto> getAllProjectedBy(Pageable pageable);
}
