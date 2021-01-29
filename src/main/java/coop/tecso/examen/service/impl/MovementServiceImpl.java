package coop.tecso.examen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.CurrentAccount;
import coop.tecso.examen.model.Movement;
import coop.tecso.examen.repository.CurrentAccountRepository;
import coop.tecso.examen.repository.MovementRepository;
import coop.tecso.examen.service.MovementService;

@Service
public class MovementServiceImpl implements MovementService{
	
	@Autowired
	private MovementRepository movementRepo;
	
	@Autowired
	private CurrentAccountRepository accountRepo;

	@Override
	public List<Movement> findByCCIdOrderByMovementDateDesc(Integer id) {
		List<Movement> listMovements = movementRepo.findByCCIdOrderByMovementDateDesc(id);
		return listMovements;
	}

	@Override
	public Movement save(Movement movementSave) {
		updateBalance(movementSave);		
		Movement movement = movementRepo.save(movementSave);
		return movement;
	}

	private void updateBalance(Movement movementSave) {
		Optional<CurrentAccount> account = accountRepo.findById(movementSave.getcC().getId());
		if(movementSave.getCredito() > 0) {
			account.get().setBalance(movementSave.getCredito() + account.get().getBalance());
		}else {
			account.get().setBalance(movementSave.getDebito() + account.get().getBalance());
		}		
	}
}