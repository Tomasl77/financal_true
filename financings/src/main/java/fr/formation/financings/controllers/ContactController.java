package fr.formation.financings.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

import fr.formation.financings.dtos.ContactDto;
import fr.formation.financings.dtos.ContactViewDto;
import fr.formation.financings.services.ContactService;

@RestController
@RequestMapping("/contacts")
@CrossOrigin("*")
public class ContactController {

    private final ContactService service;

    protected ContactController(ContactService service) {
	this.service = service;
    }

    @PostMapping
    protected void create(@Valid @RequestBody ContactDto dto) {
	service.create(dto);
    }

    @PutMapping("/{id}")
    protected void update(@PathVariable("id") Long id,
	    @Valid @RequestBody ContactDto dto) {
	service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    protected void delete(@PathVariable("id") Long id) {
	service.delete(id);
    }

    @GetMapping("/{id}")
    protected ContactViewDto getOne(@PathVariable("id") Long id) {
	return service.getOne(id);
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
    protected Page<ContactViewDto> getAll(@RequestParam("p") int page,
	    @RequestParam("s") int size, @RequestParam("by") String by) {
	Sort sort = Sort.by(Direction.ASC, by);
	Pageable pageable = PageRequest.of(page, size, sort);
	return service.getAll(pageable);
    }
}
