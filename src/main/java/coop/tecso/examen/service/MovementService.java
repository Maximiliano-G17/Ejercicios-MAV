package coop.tecso.examen.service;

import java.util.List;

import coop.tecso.examen.model.Movement;

public interface MovementService {

	List<Movement> findByCCIdOrderByMovementDateDesc(Integer id);
	
	Movement save (Movement movementSave);
}
