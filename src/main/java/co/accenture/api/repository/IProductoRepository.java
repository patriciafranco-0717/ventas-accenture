package co.accenture.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.accenture.api.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{
	public Producto getOne(Long codigo);
}
