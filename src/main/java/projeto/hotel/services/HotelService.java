package projeto.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.hotel.entities.Hotel;
import projeto.hotel.repositories.HotelRepository;

@Service
public class HotelService {

	@Autowired
	private HotelRepository repository;

	public List<Hotel> findAll() {
		return repository.findAll();
	}

	public Hotel findById(Long id) {
		Optional<Hotel> obj = repository.findById(id);
		return obj.get();
	}

	public Hotel insert(Hotel obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Hotel update(Long id, Hotel obj) {
		Hotel entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);		

	}

	private void updateData(Hotel entity, Hotel obj) {
		entity.setNomeFantasia(obj.getNomeFantasia());
		entity.setCnpj(obj.getCnpj());
	}

}
