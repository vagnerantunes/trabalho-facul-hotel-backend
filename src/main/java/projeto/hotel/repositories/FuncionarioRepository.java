package projeto.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.hotel.entities.Funcionario;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	

}
