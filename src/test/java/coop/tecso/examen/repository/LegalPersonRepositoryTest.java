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

import coop.tecso.examen.model.LegalPerson;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class LegalPersonRepositoryTest {
	
	@Autowired
	private LegalPersonRepository legalPersonRepo;
	
	@Test
	public void listarTodasLasPersonasJuridicas_retornaUnaListaConPersonasJuridicas() {
		List<LegalPerson> legalPerson = legalPersonRepo.findAll();
		
		assertEquals(2, legalPerson.size());
	}
}