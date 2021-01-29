package coop.tecso.examen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.LegalPerson;
import coop.tecso.examen.repository.LegalPersonRepository;
import coop.tecso.examen.service.LegalPersonService;

@Service
public class LegalPersonServiceImpl implements LegalPersonService{
	
	@Autowired
	private LegalPersonRepository legalPersonRepo;

	@Override
	public Optional<LegalPerson> findById(Integer id) {
		return legalPersonRepo.findById(id);
	}

	@Override
	public List<LegalPerson> findAll() {
		return legalPersonRepo.findAll();
	}

	@Override
	public LegalPerson save(LegalPerson legalPerson) {
		return legalPersonRepo.save(legalPerson);
	}

	@Override
	public void deleteById(Integer id) {
		legalPersonRepo.deleteById(id);		
	}

	@Override
	public Optional<LegalPerson> update(Optional<LegalPerson> legalPersonUdate, LegalPerson legalPerson) {
		legalPersonUdate.get().setBusinessName(legalPerson.getBusinessName());
		legalPersonUdate.get().setFoundationYear(legalPerson.getFoundationYear());
		legalPersonUdate.get().setRUT(legalPerson.getRUT());
		
		return legalPersonUdate;
	}

}
