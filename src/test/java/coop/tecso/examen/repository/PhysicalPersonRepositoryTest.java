package coop.tecso.examen.repository;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import coop.tecso.examen.model.PhysicalPerson;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PhysicalPersonRepositoryTest {
	
	@Autowired
	private PhysicalPersonRepository physicalPersonRepo;

	
	@Test
	public void listarTodasLasPersonas_retornaUnaListaConPersonas() {
		List<PhysicalPerson> people = physicalPersonRepo.findAll();
		
		assertEquals(6, people.size());
	}
	
	@Test
	public void guardaUnaPersona_retornaPersonaGuardada() {
		PhysicalPerson person = new PhysicalPerson();
		person.setCurrentAccount(true);
		person.setName("Albertno");
		person.setSurname("Gomez");
		person.setRUT(50);
		
		PhysicalPerson personSave = physicalPersonRepo.save(person);
		
		assertEquals(personSave.getRUT(), person.getRUT());
	}
	
	@Test
	public void listaTodasLasPersonasConCC_conCuentaCorrienteTrue_retornaUnaListaDePersonas() {
		List<PhysicalPerson> personWithCC = physicalPersonRepo.findByCurrentAccountTrue();
		
		assertEquals(4, personWithCC.size());
	}
}