package projeto.hotel.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String cpf;
	
	private Integer cargo;
}
