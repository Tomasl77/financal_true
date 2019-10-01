package fr.formation.financings.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.financings.dtos.FinancingViewDto;
import fr.formation.financings.entities.Financing;

@Repository // Optional, a JpaRepository is already a Repository!
public interface FinancingRepository extends JpaRepository<Financing, Long> {

    /**
     * Returns a view of the financing with given id.
     * <p>
     * A projection of one {@code Financing} in a {@code FinancingViewDto}.
     *
     * @param id the id of the financing to retrieve
     * @return a view of the financing with given id
     */
    FinancingViewDto getById(Long id);

    /**
     * Returns a view of all the financings.
     * <p>
     * A projection of many/all {@code Financing}s in a {@code List} of
     * {@code FinancingViewDto}.
     *
     * @param pageable
     *
     * @return a view of all the financings
     */
    Page<FinancingViewDto> getAllProjectedBy(Pageable pageable);
}
