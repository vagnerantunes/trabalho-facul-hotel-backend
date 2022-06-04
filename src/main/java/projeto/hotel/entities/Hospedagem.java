package projeto.hotel.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hospedagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	private Instant entrada;
	
	private Instant saida;
	
	@ManyToOne
	@JoinColumn(name = "funcionario")
	private Funcionario funcionario;
	
	
	@ManyToOne
	@JoinColumn(name = "hospede")
	private Hospede hospede;
	
	@ManyToOne
	@JoinColumn(name = "quarto")
	private Quarto quarto;

	
}