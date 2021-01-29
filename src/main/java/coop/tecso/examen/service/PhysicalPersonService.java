package coop.tecso.examen.service;

import java.util.List;
import java.util.Optional;

import coop.tecso.examen.model.PhysicalPerson;

public interface PhysicalPersonService {
	
	Optional<PhysicalPerson> finById(Integer id);

	List<PhysicalPerson> findAll();
	
	PhysicalPerson save(PhysicalPerson Person);
	
	void delete(Integer id);
	
	List<PhysicalPerson> findByCurrentAccountTrue();

	PhysicalPerson update(Optional<PhysicalPerson> personUdate, PhysicalPerson person);

}
