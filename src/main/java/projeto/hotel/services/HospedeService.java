package projeto.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.hotel.entities.Hospede;
import projeto.hotel.repositories.HospedeRepository;

@Service
public class HospedeService {

	@Autowired
	private HospedeRepository repository;

	public List<Hospede> findAll() {
		return repository.findAll();
	}

	public Hospede findById(Long id) {
		Optional<Hospede> obj = repository.findById(id);
		return obj.get();
	}

	public Hospede insert(Hospede obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Hospede update(Long id, Hospede obj) {
		Hospede entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);		

	}

	private void updateData(Hospede entity, Hospede obj) {
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setCelular(obj.getCelular());
		entity.setEmail(obj.getEmail());
		entity.setEndereco(obj.getEndereco());
	}

}
