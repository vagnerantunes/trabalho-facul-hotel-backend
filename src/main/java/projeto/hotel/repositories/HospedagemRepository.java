package projeto.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.hotel.entities.Hospedagem;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {

}
