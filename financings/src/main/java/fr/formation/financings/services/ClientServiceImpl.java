package fr.formation.financings.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.formation.financings.dtos.ClientDto;
import fr.formation.financings.dtos.ClientViewDto;
import fr.formation.financings.entities.Client;
import fr.formation.financings.entities.Contact;
import fr.formation.financings.repositories.ClientRepository;
import fr.formation.financings.repositories.ContactRepository;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepo;

    private final ContactRepository contactRepo;

    protected ClientServiceImpl(ClientRepository clientRepo,
	    ContactRepository contactRepo) {
	this.clientRepo = clientRepo;
	this.contactRepo = contactRepo;
    }

    @Override
    public void create(ClientDto dto) {
	Client client = new Client();
	populateAndSave(dto, client);
    }

    @Override
    public void update(Long id, ClientDto dto) {
	Client client = clientRepo.findById(id).get();
	populateAndSave(dto, client);
    }

    private void populateAndSave(ClientDto dto, Client client) {
	client.setLegalForm(dto.getLegalForm());
	client.setName(dto.getName());
	Long contactId = dto.getContactId();
	Contact contact = null;
	if (contactId != null) {
	    contact = contactRepo.getOne(contactId);
	}
	client.setContact(contact);
	clientRepo.save(client);
    }

    @Override
    public void delete(Long id) {
	clientRepo.deleteById(id);
    }

    @Override
    public ClientViewDto getOne(Long id) {
	return clientRepo.getById(id);
    }

    @Override
    public Page<ClientViewDto> getAll(Pageable pageable) {
	return clientRepo.getAllProjectedBy(pageable);
    }
}
