package coop.tecso.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.model.LegalPerson;
import coop.tecso.examen.service.LegalPersonService;

@RestController
@RequestMapping("legalPerson")
public class LegalPersonController {
	
	@Autowired
	private LegalPersonService legalPersonService;
	
	@GetMapping("/")
	public ResponseEntity<List<LegalPerson>> readAll() {
		List<LegalPerson> people = legalPersonService.findAll();
		return ResponseEntity.ok(people);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<LegalPerson>> read(@PathVariable Integer id) {
		Optional<LegalPerson> legalPerson = legalPersonService.findById(id);
		if(!legalPerson.isPresent()) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(legalPerson);
	}
	
	@PostMapping
	public ResponseEntity<LegalPerson> create(@RequestBody LegalPerson legalperson) {
		return ResponseEntity.status(HttpStatus.CREATED).body(legalPersonService.save(legalperson));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Optional<LegalPerson>> update(@RequestBody LegalPerson legalPerson, @PathVariable Integer id){
		Optional<LegalPerson> personUdate = legalPersonService.findById(id);
		
		if(!personUdate.isPresent()) {
			return ResponseEntity.notFound()
								 .build();
		}		
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(legalPersonService.update(personUdate,legalPerson));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<LegalPerson>> delete(@PathVariable Integer id){
		Optional<LegalPerson> personDelete = legalPersonService.findById(id);
		
		if(!personDelete.isPresent()) {
			return ResponseEntity.notFound()
								 .build();
		}		
		legalPersonService.deleteById(id);
		return ResponseEntity.ok(personDelete);
	}
}