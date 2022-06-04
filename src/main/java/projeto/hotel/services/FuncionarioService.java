package projeto.hotel.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.hotel.dto.FuncionarioDTO;
import projeto.hotel.dto.FuncionarioNewDTO;
import projeto.hotel.entities.Cargo;
import projeto.hotel.entities.Funcionario;
import projeto.hotel.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	/*
	@Autowired
	private CargoService cargoService;
	 */
	
	//listar todos
	public List<Funcionario> findAll() {
		return repository.findAll();
	}

	//listar por id
	public Funcionario findById(Integer id) {
		Optional<Funcionario> obj = repository.findById(id);
		return obj.get();
	}
	
	public Funcionario insert (FuncionarioNewDTO funcionarioNewDTO) {
		Funcionario funcionario = fromDTO(funcionarioNewDTO);
		repository.save(funcionario);
		return funcionario;
	}
	
	
	
	/*
	public Funcionario insert(Funcionario obj) {
		obj.setId(null);
		obj.setCargo(cargoService.findById(obj.getCargo().getId()));
		obj = repository.save(obj);
		return obj;
	}
	*/
	
	public void delete(Integer id) {
		Optional<Funcionario> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		repository.deleteById(id);
	}
	
	/*
	public void delete(Integer id) {				
		repository.deleteById(id);
	}
	*/
	
	public void update (Integer id, FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = fromDTO(funcionarioDTO);
		Optional<Funcionario> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		funcionario.setId(id);
		repository.save(funcionario);
	}
	
	/*
	@SuppressWarnings("deprecation")
	public Funcionario update(Integer id, Funcionario obj) {
		Funcionario entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	*/
	
	
	//utilitarios
	public Funcionario fromDTO(FuncionarioNewDTO funcionarioNewDTO) {
		Cargo cargo = new Cargo(funcionarioNewDTO.getCargo(), null);
		Funcionario funcionario = new Funcionario(null, funcionarioNewDTO.getNome(), funcionarioNewDTO.getCpf(), cargo);
		
		return funcionario;
	}
	
	public Funcionario fromDTO(FuncionarioDTO funcionarioDTO) {
		Cargo cargo = new Cargo(funcionarioDTO.getCargo(), null);
		Funcionario funcionario = new Funcionario(null, funcionarioDTO.getNome(), funcionarioDTO.getCpf(), cargo);
		return funcionario;
	}
	
	/*
	private void updateData(Funcionario entity, Funcionario obj) {
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setCargo(obj.getCargo());
	}
	*/
}
