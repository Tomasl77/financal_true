package fr.formation.financings.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.formation.financings.dtos.BankDto;
import fr.formation.financings.dtos.BankViewDto;

public interface BankService {

    void create(BankDto bankDto);

    void update(Long id, BankDto bankDto);

    void deleteOne(Long id);

    void deleteMany();

    BankViewDto getOne(Long id);

    Page<BankViewDto> getAll(Pageable pageable);
}
