package coop.tecso.examen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.CurrentAccount;
import coop.tecso.examen.repository.CurrentAccountRepository;
import coop.tecso.examen.service.CurrentAccountService;

@Service
public class CurrentAccountServiceImpl implements CurrentAccountService{
	
	@Autowired
	private CurrentAccountRepository currentAccountRepo;
	
	public CurrentAccount save(CurrentAccount currentAccount){
		CurrentAccount account = currentAccountRepo.save(currentAccount);
		return account;
	}
	
	public void deleteById(Integer id){
		currentAccountRepo.deleteById(id);
	}
	
	public List<CurrentAccount> findAll(){
		List<CurrentAccount> listAccount = currentAccountRepo.findAll();		
		return listAccount;
	}

	@Override
	public Optional<CurrentAccount> findById(Integer id) {
		return currentAccountRepo.findById(id);
	}
}
