package projeto.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.hotel.entities.Cargo;
import projeto.hotel.repositories.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;

	public List<Cargo> findAll() {
		return repository.findAll();
	}

	public Cargo findById(Integer id) {
		Optional<Cargo> obj = repository.findById(id);
		return obj.get();
	}

	public Cargo insert(Cargo obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Cargo update(Integer id, Cargo obj) {
		Cargo entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);		

	}

	private void updateData(Cargo entity, Cargo obj) {
		entity.setNome(obj.getNome());
	}

}
