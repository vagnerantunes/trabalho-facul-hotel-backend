package projeto.hotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.hotel.entities.Quarto;
import projeto.hotel.repositories.QuartoRepository;

@Service
public class QuartoService {

	@Autowired
	private QuartoRepository repository;

	@Autowired
	private HotelService hotelService;

	public List<Quarto> findAll() {
		return repository.findAll();
	}

	public Quarto findById(Long id) {
		Optional<Quarto> obj = repository.findById(id);
		return obj.get();
	}

	public Quarto insert(Quarto obj) {
		obj.setId(null);
		obj.setHotel(hotelService.findById(obj.getHotel().getId()));
		obj = repository.save(obj);
		return obj;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Quarto update(Long id, Quarto obj) {
		Quarto entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Quarto entity, Quarto obj) {
		entity.setNumero(obj.getNumero());
		entity.setHotel(obj.getHotel());
	}
}
