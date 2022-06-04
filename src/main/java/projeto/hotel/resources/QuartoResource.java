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

import projeto.hotel.entities.Quarto;
import projeto.hotel.services.QuartoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/quartos")
public class QuartoResource {
	
	@Autowired
	private QuartoService service;
	
	@GetMapping
	public ResponseEntity<List<Quarto>> findAll(){
		List<Quarto> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Quarto> findById(@PathVariable Long id){
		Quarto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Quarto> insert(@RequestBody Quarto obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Quarto> update(@PathVariable Long id, @RequestBody Quarto obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
	
}