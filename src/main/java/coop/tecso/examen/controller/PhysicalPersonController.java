package coop.tecso.examen.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import coop.tecso.examen.model.PhysicalPerson;
import coop.tecso.examen.service.PhysicalPersonService;


@RestController
@RequestMapping("people")
public class PhysicalPersonController {
	
	@Autowired
	private PhysicalPersonService physicalPersonService;
	
	@GetMapping("/")
	public ResponseEntity<List<PhysicalPerson>> readAll() {
		List<PhysicalPerson> people = physicalPersonService.findAll();
		return ResponseEntity.ok(people);
	}
	
	@GetMapping("/CC/")
	public ResponseEntity<List<PhysicalPerson>> readOnlyCC() {
		List<PhysicalPerson> people = physicalPersonService.findByCurrentAccountTrue();
		return ResponseEntity.ok(people);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<PhysicalPerson>> read(@PathVariable Integer id) {
		Optional<PhysicalPerson> person = physicalPersonService.finById(id);
		if(!person.isPresent()) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(person);
	}
	
	@PostMapping
	public ResponseEntity<PhysicalPerson> create(@Valid @RequestBody PhysicalPerson person, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error: " + seeErrors(result));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(physicalPersonService.save(person));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PhysicalPerson> update(@RequestBody PhysicalPerson person, @PathVariable Integer id){
		Optional<PhysicalPerson> personUdate = physicalPersonService.finById(id);
		
		if(!personUdate.isPresent()) {
			return ResponseEntity.notFound()
								 .build();
		}		
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(physicalPersonService.update(personUdate,person));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PhysicalPerson> delete(@PathVariable Integer id){
		Optional<PhysicalPerson> personDelete = physicalPersonService.finById(id);
		
		if(!personDelete.isPresent()) {
			return ResponseEntity.notFound()
								 .build();
		}		
		physicalPersonService.delete(id);
		return ResponseEntity.ok(personDelete.get());
	}
	
	private List<String> seeErrors(BindingResult result) {		
		List<String> errors = result.getAllErrors()
									.stream()
									.map(error -> error.getDefaultMessage())
									.collect(Collectors.toList());
		return errors;
	}
}