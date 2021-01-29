package coop.tecso.examen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.PhysicalPerson;
import coop.tecso.examen.repository.PhysicalPersonRepository;
import coop.tecso.examen.service.PhysicalPersonService;

@Service
public class PhysicalPersonServiceImpl implements PhysicalPersonService{
		
	private PhysicalPersonRepository physcalPersonRepo;
	
	@Autowired
	public PhysicalPersonServiceImpl(PhysicalPersonRepository physcalPersonRepo) {
		this.physcalPersonRepo = physcalPersonRepo;
	}

	@Override
	public List<PhysicalPerson> findAll() {
		return physcalPersonRepo.findAll();
	}

	@Override
	public PhysicalPerson save(PhysicalPerson Person) {
		return physcalPersonRepo.save(Person);
	}

	@Override
	public void delete(Integer id) {
		physcalPersonRepo.deleteById(id);
	}
	
	@Override
	public List<PhysicalPerson> findByCurrentAccountTrue() {
		return physcalPersonRepo.findByCurrentAccountTrue();
	}

	@Override
	public Optional<PhysicalPerson> finById(Integer id) {
		return physcalPersonRepo.findById(id);
	}

	@Override
	public PhysicalPerson update(Optional<PhysicalPerson> personUdate, PhysicalPerson person) {
		personUdate.get().setName(person.getName());
		personUdate.get().setSurname(person.getSurname());
		personUdate.get().setRUT(person.getRUT());
		return personUdate.get();
	}
}