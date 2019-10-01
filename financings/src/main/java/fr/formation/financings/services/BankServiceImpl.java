package fr.formation.financings.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.formation.financings.dtos.BankDto;
import fr.formation.financings.dtos.BankViewDto;
import fr.formation.financings.entities.Bank;
import fr.formation.financings.repositories.BankRepository;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepo;

    protected BankServiceImpl(BankRepository bankRepo) {
	this.bankRepo = bankRepo;
    }

    @Override
    public void create(BankDto bankDto) {
	Bank createBank = new Bank();
	populateAndSave(bankDto, createBank);
    }

    @Override
    public void deleteOne(Long id) {
	bankRepo.deleteById(id);
    }

    @Override
    public void deleteMany() {
	// TODO Auto-generated method stub
    }

    @Override
    public BankViewDto getOne(Long id) {
	return bankRepo.getById(id);
    }

    @Override
    public void update(Long id, BankDto bankDto) {
	Bank updateBank = bankRepo.findById(id).get();
	populateAndSave(bankDto, updateBank);
    }

    private void populateAndSave(BankDto bankDto, Bank createBank) {
	createBank.setAdress(bankDto.getAdress());
	createBank.setCity(bankDto.getCity());
	createBank.setName(bankDto.getName());
	createBank.setZipcode(bankDto.getZipcode());
	createBank.setSiret(bankDto.getSiret());
	bankRepo.save(createBank);
    }

    @Override
    public Page<BankViewDto> getAll(Pageable pageable) {
	return bankRepo.getAllProjectedBy(pageable);
    }
}
