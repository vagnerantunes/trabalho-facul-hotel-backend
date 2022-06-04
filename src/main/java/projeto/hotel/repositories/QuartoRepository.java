package projeto.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.hotel.entities.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {

}
