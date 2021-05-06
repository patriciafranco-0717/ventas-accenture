package co.accenture.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.accenture.api.dto.FacturaDto;
import co.accenture.api.model.Venta;
import co.accenture.api.service.IVentaService;

@RestController
@RequestMapping("/pedido")
@CrossOrigin("*")
public class VentaController {
	
	@Autowired
	private IVentaService pedidoService;
	
	@PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public FacturaDto guardar(@RequestBody @Valid Venta venta) throws Exception{
		return pedidoService.guardar(venta);
	}
	
	@PutMapping(value = "/edit/{id}")
	public String editar(@RequestBody Venta venta,
			@PathVariable("id") Long id) {
		return pedidoService.editar(venta, id);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String eliminar(Long id) {
		return pedidoService.borrar(id);
	}
	
}
