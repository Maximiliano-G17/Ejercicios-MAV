package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "legal_person")
public class LegalPerson {
	
	@Id
	@NotNull(message = "The RUT cannot be empty")
	private Integer RUT;
	@NotEmpty(message = "The RUT cannot be empty")
	@Column(length = 100)
	private String businessName;
	@NotEmpty(message = "The RUT cannot be empty")
	private String foundationYear;
	
	public Integer getRUT() {
		return RUT;
	}
	public void setRUT(Integer rUT) {
		RUT = rUT;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getFoundationYear() {
		return foundationYear;
	}
	public void setFoundationYear(String foundationYear) {
		this.foundationYear = foundationYear;
	}
}