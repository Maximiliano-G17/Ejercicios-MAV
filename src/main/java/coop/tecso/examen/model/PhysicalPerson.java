package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "physical_person")
public class PhysicalPerson {

	@Id
	@NotNull(message = "The RUT cannot be empty")
	private Integer RUT;
	@Column(length = 80)
	@NotEmpty(message = "The name cannot be empty")
	private String name;
	@Column(length = 250)
	@NotEmpty(message = "The surname cannot be empty")
	private String surname;
	@NotNull(message = "The Current Account cannot be empty")
	private boolean currentAccount;
	
	public Integer getRUT() {
		return RUT;
	}
	public void setRUT(Integer rUT) {
		RUT = rUT;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public boolean isCurrentAccount() {
		return currentAccount;
	}
	public void setCurrentAccount(boolean currentAccount) {
		this.currentAccount = currentAccount;
	}
}