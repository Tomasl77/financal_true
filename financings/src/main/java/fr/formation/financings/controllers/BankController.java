package fr.formation.financings.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.financings.dtos.BankDto;
import fr.formation.financings.dtos.BankViewDto;
import fr.formation.financings.services.BankService;

@RestController
@RequestMapping("/banks")
public class BankController {

    private final BankService bankservice;

    protected BankController(BankService bankservice) {
	this.bankservice = bankservice;
    }

    @GetMapping("/{id}")
    protected BankViewDto getOne(@PathVariable("id") Long id) {
	return bankservice.getOne(id);
    }

    @PostMapping
    protected void create(@Valid @RequestBody BankDto bankdto) {
	bankservice.create(bankdto);
    }

    @PutMapping("/{id}")
    protected void update(@PathVariable("id") Long id,
	    @RequestBody BankDto bankDto) {
	bankservice.update(id, bankDto);
    }

    @DeleteMapping("/{id}")
    protected void deleteOne(@PathVariable("id") Long id) {
	bankservice.deleteOne(id);
    }

    @GetMapping
    protected Page<BankViewDto> getAll(@RequestParam("p") int page,
	    @RequestParam("s") int size) {
	Pageable pageable = PageRequest.of(page, size);
	return bankservice.getAll(pageable);
    }
}
