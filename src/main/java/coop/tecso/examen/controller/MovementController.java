package coop.tecso.examen.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import coop.tecso.examen.model.Movement;
import coop.tecso.examen.service.MovementService;

@RestController
@RequestMapping("movement")
public class MovementController {

	@Autowired
	private MovementService movementService;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Movement>> realAllByAccount(@PathVariable Integer id){
		List<Movement> allMovements = movementService.findByCCIdOrderByMovementDateDesc(id);
		if(allMovements.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allMovements);
	}
	
	@PostMapping
	public ResponseEntity<Movement> create(@Valid @RequestBody Movement movement, BindingResult result){
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error: " + seeErrors(result));
		}
		Movement movementSave = movementService.save(movement);
		return ResponseEntity.ok(movementSave);
	}
	
	private List<String> seeErrors(BindingResult result) {		
		List<String> errors = result.getAllErrors()
									.stream()
									.map(error -> error.getDefaultMessage())
									.collect(Collectors.toList());
		return errors;
	}
}
