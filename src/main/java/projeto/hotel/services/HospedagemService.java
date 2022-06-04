package projeto.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.hotel.entities.Hospedagem;
import projeto.hotel.repositories.HospedagemRepository;

@Service
public class HospedagemService {

	@Autowired
	private HospedagemRepository repository;

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private HospedeService hospedeService;
	
	@Autowired
	private QuartoService quartoService;

	public List<Hospedagem> findAll() {
		return repository.findAll();
	}

	public Hospedagem findById(Long id) {
		Optional<Hospedagem> obj = repository.findById(id);
		return obj.get();
	}

	public Hospedagem insert(Hospedagem obj) {
		obj.setId(null);
		obj.setFuncionario(funcionarioService.findById(obj.getFuncionario().getId()));
		obj.setHospede(hospedeService.findById(obj.getHospede().getId()));
		obj.setQuarto(quartoService.findById(obj.getQuarto().getId()));
		obj = repository.save(obj);
		return obj;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Hospedagem update(Long id, Hospedagem obj) {
		Hospedagem entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Hospedagem entity, Hospedagem obj) {
		entity.setEntrada(obj.getEntrada());
		entity.setSaida(obj.getSaida());
		entity.setFuncionario(obj.getFuncionario());
		entity.setHospede(obj.getHospede());
		entity.setQuarto(obj.getQuarto());
	}
}
