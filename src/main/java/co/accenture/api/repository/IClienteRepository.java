package co.accenture.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.accenture.api.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, String>{
	
}
