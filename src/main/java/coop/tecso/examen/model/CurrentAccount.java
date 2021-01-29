package coop.tecso.examen.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CurrentsAccounts")
public class CurrentAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "The balance cannot be empty")
	private Double balance = 0D;
	@Min(message = "must be 0 or positive", value = 0)
	private Double moneyPesos;
	@Min(message = "must be 0 or positive", value = 0)
	private Double moneyDolar;
	@Min(message = "must be 0 or positive", value = 0)
	private Double moneyEuro;
	@JsonManagedReference
	@OneToMany(mappedBy = "cC",cascade = CascadeType.ALL)
	private List<Movement> movements;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getMoneyPesos() {
		return moneyPesos;
	}
	public void setMoneyPesos(Double moneyPesos) {
		this.moneyPesos = moneyPesos;
	}
	public Double getMoneyDolar() {
		return moneyDolar;
	}
	public void setMoneyDolar(Double moneyDolar) {
		this.moneyDolar = moneyDolar;
	}
	public Double getMoneyEuro() {
		return moneyEuro;
	}
	public void setMoneyEuro(Double moneyEuro) {
		this.moneyEuro = moneyEuro;
	}
	public List<Movement> getMovements() {
		return movements;
	}
	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
}