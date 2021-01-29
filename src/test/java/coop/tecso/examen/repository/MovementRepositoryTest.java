package coop.tecso.examen.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import coop.tecso.examen.model.CurrentAccount;
import coop.tecso.examen.model.Movement;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MovementRepositoryTest {
	
	@Autowired
	private MovementRepository movementRepo;
	
	@Autowired
	private CurrentAccountRepository currentAccountRepo;
	
	@Test
	public void listarMovimientosPorCuenta_ConCuentaExistente_RetornaListaDeMovimientos() {
		Integer id = 1;
		List<Movement> listMovement = movementRepo.findByCCIdOrderByMovementDateDesc(id);
		
		assertEquals(4, listMovement.size());
	}
	
	@Test
	public void agregarMovimiento_conIdCuentaExistente() {
		Integer idCurrentAccount = 1;
		
		Optional<CurrentAccount> cC = currentAccountRepo.findById(idCurrentAccount);
		Movement movementSave = new Movement();
		movementSave.setCredito(10.055);
		movementSave.setDescription("asdasdasdsa");
		movementSave.setcC(cC.get());
		movementSave.setMovementDate("2011/1/5");
		Movement movement = movementRepo.save(movementSave);
		assertEquals("asdasdasdsa", movement.getDescription());
	}
}