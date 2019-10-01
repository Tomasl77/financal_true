package fr.formation.financings.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.formation.financings.dtos.FinancingDto;
import fr.formation.financings.dtos.FinancingViewDto;
import fr.formation.financings.entities.Client;
import fr.formation.financings.entities.Financing;
import fr.formation.financings.repositories.ClientRepository;
import fr.formation.financings.repositories.FinancingRepository;

@Service // defines this class as a service
public class FinancingServiceImpl implements FinancingService {

    private final FinancingRepository financingRepo;

    private final ClientRepository clientRepo;

    // Injects repositories
    protected FinancingServiceImpl(FinancingRepository financingRepo,
	    ClientRepository clientRepo) {
	this.financingRepo = financingRepo;
	this.clientRepo = clientRepo;
    }

    @Override
    public void create(FinancingDto dto) {
	Financing financing = new Financing();
	populateAndSave(dto, financing);
    }

    @Override
    public void update(Long id, FinancingDto dto) {
	// findById returns an Optional object!
	Financing financing = financingRepo.findById(id).get();
	populateAndSave(dto, financing);
    }

    private void populateAndSave(FinancingDto dto, Financing financing) {
	// Convert dto to entity:
	financing.setName(dto.getName());
	financing.setAmount(dto.getAmount());
	financing.setReference(dto.getReference());
	financing.setRate(dto.getRate());
	financing.setStartDate(dto.getStartDate());
	financing.setEndDate(dto.getEndDate());
	// Financing needs a Client object, not a Client id:
	Client client = clientRepo.getOne(dto.getClientId());
	financing.setClient(client);
	financingRepo.save(financing); // Save to database
    }

    @Override
    public void delete(Long id) {
	financingRepo.deleteById(id);
    }

    @Override
    public FinancingViewDto getOne(Long id) {
	return financingRepo.getById(id);
    }

    @Override
    public void validate(Long id) {
	// findById returns an Optional object!
	Financing financing = financingRepo.findById(id).get();
	financing.setValidated(true);
	financingRepo.save(financing);
    }

    @Override
    public List<FinancingViewDto> getAll(int page, int size) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Page<FinancingViewDto> getAll(Pageable pageable) {
	return financingRepo.getAllProjectedBy(pageable);
    }
}
