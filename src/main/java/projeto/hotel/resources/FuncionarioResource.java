package projeto.hotel.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import projeto.hotel.dto.FuncionarioDTO;
import projeto.hotel.dto.FuncionarioNewDTO;
import projeto.hotel.entities.Funcionario;
import projeto.hotel.services.FuncionarioService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService service;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll(){
		List<Funcionario> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Integer id){
		Funcionario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Void> save (@RequestBody @Valid FuncionarioNewDTO funcionarioNewDTO){
		Funcionario funcionario = service.insert(funcionarioNewDTO);
		
		//boas praticas, ao inserir um recurso retornar sua URI (endereco) onde foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(funcionario.getId()).toUri(); 
		
		return ResponseEntity.created(uri).build();
	}
	
	/*
	@PostMapping
	public ResponseEntity<Funcionario> insert(@RequestBody Funcionario obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
		
	}
	*/
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update (@PathVariable Integer id, @RequestBody @Valid FuncionarioDTO funcionarioDTO){
		service.update(id, funcionarioDTO);
		return ResponseEntity.ok().build();
	}
	
	
	/*
	@PutMapping(value = "/{id}")
	public ResponseEntity<Funcionario> update(@PathVariable Integer id, @RequestBody Funcionario obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
	*/

	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok().build();
		
	}
	
	
}