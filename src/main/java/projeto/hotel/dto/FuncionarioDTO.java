package projeto.hotel.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FuncionarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String nome;
	
	private String cpf;
	
	private Integer cargo;

}
