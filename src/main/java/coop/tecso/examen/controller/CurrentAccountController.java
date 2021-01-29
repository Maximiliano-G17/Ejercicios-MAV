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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import coop.tecso.examen.model.CurrentAccount;
import coop.tecso.examen.service.CurrentAccountService;

@RestController
@RequestMapping("currentAccount")
public class CurrentAccountController {
	
	@Autowired
	private CurrentAccountService currentAccount;
	
	@GetMapping
	public ResponseEntity<List<CurrentAccount>> readAll(){
		List<CurrentAccount> listAllAccount = currentAccount.findAll();
		if(listAllAccount.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(listAllAccount);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<CurrentAccount>> delete(@PathVariable Integer id){
		Optional<CurrentAccount> accountDelete = currentAccount.findById(id);
		if(!accountDelete.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		if(!accountDelete.get().getMovements().isEmpty()) {
			currentAccount.deleteById(id);
			return ResponseEntity.ok(accountDelete);
		}		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CurrentAccount> create(@Valid @RequestBody CurrentAccount account, BindingResult result){
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error: " + seeErrors(result));
		}
		CurrentAccount accountSave = currentAccount.save(account);
		return ResponseEntity.ok(accountSave);
	}
	
	private List<String> seeErrors(BindingResult result) {		
		List<String> errors = result.getAllErrors()
									.stream()
									.map(error -> error.getDefaultMessage())
									.collect(Collectors.toList());
		return errors;
	}
}








