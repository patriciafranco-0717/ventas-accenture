package co.accenture.api.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.accenture.api.dto.FacturaDto;
import co.accenture.api.dto.ProductoDto;
import co.accenture.api.model.Producto;
import co.accenture.api.model.Venta;
import co.accenture.api.repository.IProductoRepository;
import co.accenture.api.repository.IVentaRepository;
import co.accenture.api.util.Constante;

@Service
public class VentaService implements IVentaService{
	
	@Autowired
	private IVentaRepository pedidoRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Override
	public FacturaDto guardar(Venta venta) throws Exception{
		FacturaDto factura = new FacturaDto();
		List<ProductoDto> productos = new ArrayList<>();
		Float iva = (float) 0.0;
		Double domicilio = 0.0;
		Double total = venta.getDetalles()
				.stream()
				.mapToDouble(p -> {
					Long codigo = p.getProducto().getCodigo();
					Producto prod = productoRepository.getOne(codigo);
					Double precioUnitario = prod.getPrecioUnitario();
					if(prod.getStock() < p.getCantidad()) {
						throw new RuntimeException("Sin Stock");
					}
					ProductoDto pDto = new ProductoDto();
					pDto.setCodigo(prod.getCodigo());
					pDto.setNombre(prod.getNombre());
					productos.add(pDto);
					return p.getCantidad()*precioUnitario;
				})
				.sum();
		if(total > Constante.LIMITE_1) {
			iva = Constante.IVA;
			domicilio = Constante.DOMICILIO;
		}if(total  > Constante.LIMITE_2) {
			iva = (float) 0.0;
			domicilio = 0.0;
		}
		factura.setCliente(venta.getCliente());
		factura.setDomicilio(domicilio);
		factura.setIva(total*iva);
		factura.setTotal(total + (total*iva) + domicilio);
		factura.setSubTotal(total);
		factura.setProductos(productos);
		venta.setTotal(total);
		venta.setDomicilio(domicilio);
		venta.setSubtotal(total + (total*iva) + domicilio);
		venta.setIva(iva);
		pedidoRepository.save(venta);
		return factura;
	}

	@Override
	public String editar(Venta pedido, Long id) {
		Venta ped = pedidoRepository.getOne(id);
		Double iva = 0.0;
		Double domicilio = 0.0;
		List<ProductoDto> productos = new ArrayList<>();
		if(ped != null) {
	        LocalDateTime hoy = LocalDateTime.now();
	        LocalDateTime tiempoCompra = ped.getFecha();
	        long time = tiempoCompra.until(hoy, ChronoUnit.MINUTES);
			if(time > Constante.TIEMPO_1) {
				return "Fuera de tiempo!";
			}
			Double total = pedido.getDetalles()
					.stream()
					.mapToDouble(p -> {
						Long codigo = p.getProducto().getCodigo();
						Producto prod = productoRepository.getOne(codigo);
						Double precioUnitario = prod.getPrecioUnitario();
						if(prod.getStock() < p.getCantidad()) {
							throw new RuntimeException("No hay stock");
						}
						ProductoDto pDto = new ProductoDto();
						pDto.setCodigo(prod.getCodigo());
						pDto.setNombre(prod.getNombre());
						productos.add(pDto);
						return p.getCantidad()*precioUnitario;
					})
					.sum();
			if(total < ped.getTotal()){
				return "El precio supera!";
			}
			if(ped.getTotal() == Constante.LIMITE_1 && total > Constante.LIMITE_2) {
				total = total - Constante.DOMICILIO;
			}
			// seteo variables pedido modificado
			//----
			//pedidoRepository.save(ped);
		}
		return "OK!";
		
	}

	@Override
	public String borrar(Long id) {
		Optional<Venta> pedidoOpc = pedidoRepository.findById(id);
		if(pedidoOpc.isPresent()) {
	        LocalDateTime hoy = LocalDateTime.now();
	        LocalDateTime tiempoCompra = pedidoOpc.get().getFecha();
	        long time = tiempoCompra.until(hoy, ChronoUnit.MINUTES);
			if(time > Constante.TIEMPO_2) {
				return "Fuera de tiempo!";
			}
		}
		
		return "OK!";
	}	
}
