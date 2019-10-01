package fr.formation.financings.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.formation.financings.dtos.FinancingDto;
import fr.formation.financings.dtos.FinancingViewDto;

public interface FinancingService {

    void create(FinancingDto dto);

    void delete(Long id);

    FinancingViewDto getOne(Long id);

    List<FinancingViewDto> getAll(int page, int size);

    void validate(Long id);

    void update(Long id, FinancingDto dto);

    Page<FinancingViewDto> getAll(Pageable pageable);
}
