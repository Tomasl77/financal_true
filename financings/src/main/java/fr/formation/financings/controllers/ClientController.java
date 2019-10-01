package fr.formation.financings.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.financings.dtos.ClientDto;
import fr.formation.financings.dtos.ClientViewDto;
import fr.formation.financings.services.ClientService;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class ClientController {

    private final ClientService service;

    protected ClientController(ClientService service) {
	this.service = service;
    }

    @GetMapping("/{id}")
    protected ClientViewDto getOne(@PathVariable("id") Long id) {
	return service.getOne(id);
    }

    @PostMapping
    protected void create(@Valid @RequestBody ClientDto dto) {
	service.create(dto);
    }

    @PutMapping("/{id}")
    protected void update(@PathVariable("id") Long id,
	    @Valid @RequestBody ClientDto dto) {
	service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    protected void delete(@PathVariable("id") Long id) {
	service.delete(id);
    }

    /**
     * Searches and retrieves all the contacts as {@code ContactViewDto} with
     * paging.
     *
     * @param page the page number, starting from {@code 0}
     * @param size the size of the page
     * @return a {@code Page} of {@code ContactViewDto}
     */
    @GetMapping
    protected Page<ClientViewDto> getAll(@RequestParam("p") int page,
	    @RequestParam("s") int size) {
	Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
	return service.getAll(pageable);
    }
}
