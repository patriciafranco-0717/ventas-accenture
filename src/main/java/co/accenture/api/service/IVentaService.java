package co.accenture.api.service;



import co.accenture.api.dto.FacturaDto;
import co.accenture.api.model.Venta;

public interface IVentaService {
	
	public FacturaDto guardar(Venta venta) throws Exception;

	public String editar(Venta venta, Long id);
	
	public String borrar(Long id);
}
