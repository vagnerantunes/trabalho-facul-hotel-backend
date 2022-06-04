package projeto.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.hotel.entities.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>{

}
