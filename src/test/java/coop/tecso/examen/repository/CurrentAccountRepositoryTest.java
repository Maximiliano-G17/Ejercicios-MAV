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

import coop.tecso.examen.model.CurrentAccount;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CurrentAccountRepositoryTest {
	
	@Autowired
	private CurrentAccountRepository currentAccountRepo;
	
	@Test
	public void crearCuentas() {
		CurrentAccount accountNew = new CurrentAccount();
		//accountNew.setBalance(3333.88);
		accountNew.setMoneyEuro(44.55);
		
		currentAccountRepo.save(accountNew);
		List<CurrentAccount> listAccount = currentAccountRepo.findAll();
		assertEquals(3, listAccount.size());
	}
	
	@Test
	public void listarTodasLasCuentas_retornaUnaListaDeCuentas() {
		List<CurrentAccount> listAccount = currentAccountRepo.findAll();
		
		assertEquals(2, listAccount.size());
	}
	
	@Test
	public void eliminarCuenta_conIdExistente() {
		Integer idCurrentAccount = 1;
		
		currentAccountRepo.deleteById(idCurrentAccount);
		List<CurrentAccount> listAccount = currentAccountRepo.findAll();
		
		assertEquals(1, listAccount.size());
	}
}