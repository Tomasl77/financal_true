package fr.formation.financings.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.financings.dtos.FinancingDto;
import fr.formation.financings.dtos.FinancingViewDto;
import fr.formation.financings.services.FinancingService;

/**
 * A collection of resources ({@code Financing}s).
 * <p>
 * Exposes endpoints in order to create, update, delete and retrieve these
 * resources.
 */
@RestController // defines this class as a Rest controller
@RequestMapping("/financings") // root segment defining the collection
@CrossOrigin("*")
public class FinancingController {

    // Service is injected by Spring during startup of the application
    private final FinancingService service;

    /**
     * Creates a new {@code FinancingController} with given injected service.
     *
     * @param service an injected {@code FinancingService}
     */
    protected FinancingController(FinancingService service) {
	this.service = service;
    }

    /**
     * Endpoint to create a resource (financing) with given inputs.
     *
     * @param dto the inputs of the Rest client
     */
    @PostMapping
    protected void create(@Valid @RequestBody FinancingDto dto) {
	service.create(dto);
    }

    /**
     * Endpoint to update a resource (financing) with given id and inputs.
     *
     * @param id  the id of the resource to update
     * @param dto the inputs of the Rest client
     */
    @PutMapping("/{id}")
    protected void update(@PathVariable("id") Long id,
	    @Valid @RequestBody FinancingDto dto) {
	service.update(id, dto);
    }

    /**
     * Endpoint to delete the resource (financing) with given id.
     *
     * @param id the id of the resource to delete
     */
    @DeleteMapping("/{id}")
    protected void delete(@PathVariable("id") Long id) {
	service.delete(id);
    }

    /**
     * Endpoint to retrieve the resource (financing) with given id.
     *
     * @param id the id of the resource to retrieve
     * @return a view of the resource
     */
    @GetMapping("/{id}")
    protected FinancingViewDto getOne(@PathVariable("id") Long id) {
	return service.getOne(id);
    }

    /**
     * Endpoint to retrieve all the resources (financings).
     *
     * @return a view of the resources
     */
    @GetMapping
    protected Page<FinancingViewDto> getAll(@RequestParam("p") int page,
	    @RequestParam("s") int size) {
	Pageable pageable = PageRequest.of(page, size);
	return service.getAll(pageable);
    }

    /**
     * Endpoint to patch a financing, marking it as validated.
     *
     * @param id the id of the resource to patch
     */
    @PatchMapping("/{id}/validate")
    protected void validate(@PathVariable("id") Long id) {
	service.validate(id);
    }
}
