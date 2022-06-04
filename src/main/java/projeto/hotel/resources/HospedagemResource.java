package projeto.hotel.resources;

import java.util.List;

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

import projeto.hotel.entities.Hospedagem;
import projeto.hotel.services.HospedagemService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/hospedagens")
public class HospedagemResource {
	
	@Autowired
	private HospedagemService service;
	
	@GetMapping
	public ResponseEntity<List<Hospedagem>> findAll(){
		List<Hospedagem> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Hospedagem> findById(@PathVariable Long id){
		Hospedagem obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Hospedagem> insert(@RequestBody Hospedagem obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Hospedagem> update(@PathVariable Long id, @RequestBody Hospedagem obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
	
}