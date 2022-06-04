package projeto.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.hotel.entities.Hospede;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long>{

}
