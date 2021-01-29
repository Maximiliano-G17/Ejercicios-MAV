package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "movements")
public class Movement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "The date cannot be empty")
	private String movementDate;
	@Min(message = "must be 0 or positive", value = 0)
	private Double debito = 0D;
	@Min(message = "must be 0 or positive", value = 0)
	private Double credito = 0D;
	@Column(length = 200)
	@NotEmpty(message = "The description cannot be empty")
	private String description;
	@NotNull(message = "The amount cannot be empty")
	private Double amount;
	@NotNull(message = "The current account cannot be empty")
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "cc_id")
	private CurrentAccount cC;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMovementDate() {
		return movementDate;
	}
	public void setMovementDate(String movementDate) {
		this.movementDate = movementDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getDebito() {
		return debito;
	}
	public void setDebito(Double debito) {
		this.debito += debito;
	}
	public Double getCredito() {
		return credito;
	}
	public void setCredito(Double credito) {
		this.credito += credito;
	}
	public CurrentAccount getcC() {
		return cC;
	}
	public void setcC(CurrentAccount cC) {
		this.cC = cC;
	}
}