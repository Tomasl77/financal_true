package fr.formation.financings.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.formation.financings.dtos.ContactDto;
import fr.formation.financings.dtos.ContactViewDto;
import fr.formation.financings.entities.Contact;
import fr.formation.financings.entities.ContactInfo;
import fr.formation.financings.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repo;

    protected ContactServiceImpl(ContactRepository repo) {
	this.repo = repo;
    }

    @Override
    public void create(ContactDto dto) {
	Contact contact = new Contact();
	populateAndSave(dto, contact);
    }

    @Override
    public void update(Long id, ContactDto dto) {
	Contact contact = repo.findById(id).get();
	populateAndSave(dto, contact);
    }

    private void populateAndSave(ContactDto dto, Contact contact) {
	contact.setFirstName(dto.getFirstName());
	contact.setLastName(dto.getLastName());
	ContactInfo info = new ContactInfo();
	info.setEmail(dto.getEmail());
	info.setPhone(dto.getPhone());
	info.setMobile(dto.getMobile());
	contact.setInfo(info);
	repo.save(contact);
    }

    @Override
    public void delete(Long id) {
	repo.deleteById(id);
    }

    @Override
    public ContactViewDto getOne(Long id) {
	return repo.getById(id);
    }

    @Override
    public Page<ContactViewDto> getAll(Pageable pageable) {
	return repo.getAllProjectedBy(pageable);
    }
}
