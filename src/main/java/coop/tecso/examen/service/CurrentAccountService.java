package coop.tecso.examen.service;

import java.util.List;
import java.util.Optional;

import coop.tecso.examen.model.CurrentAccount;

public interface CurrentAccountService {

	CurrentAccount save(CurrentAccount currentAccount);
	
	void deleteById(Integer id);
	
	List<CurrentAccount> findAll();
	
	Optional<CurrentAccount> findById(Integer id);
}
