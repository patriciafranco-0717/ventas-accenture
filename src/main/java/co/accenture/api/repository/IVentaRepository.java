package co.accenture.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.accenture.api.model.Venta;

public interface IVentaRepository extends JpaRepository<Venta, Long>{
	
}
