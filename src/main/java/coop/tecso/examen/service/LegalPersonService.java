package coop.tecso.examen.service;

import java.util.List;
import java.util.Optional;

import coop.tecso.examen.model.LegalPerson;

public interface LegalPersonService{
	
	Optional<LegalPerson> findById(Integer Id);
	
	List<LegalPerson> findAll();
	
	LegalPerson save(LegalPerson legalPerson);
	
	void deleteById(Integer id);

	Optional<LegalPerson> update(Optional<LegalPerson> personUdate, LegalPerson legalPerson);

}
