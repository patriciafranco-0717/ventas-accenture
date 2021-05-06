package co.accenture.api.dto;

import java.util.List;

import co.accenture.api.model.Cliente;

public class FacturaDto {
	private Cliente cliente;
	private List<ProductoDto> productos;
	private Double subTotal;
	private Double total;
	private Double iva;
	private Double domicilio;
	
	public FacturaDto() {
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the productos
	 */
	public List<ProductoDto> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<ProductoDto> productos) {
		this.productos = productos;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * @return the iva
	 */
	public Double getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(Double iva) {
		this.iva = iva;
	}

	/**
	 * @return the domicilio
	 */
	public Double getDomicilio() {
		return domicilio;
	}

	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(Double domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * @return the subTotal
	 */
	public Double getSubTotal() {
		return subTotal;
	}

	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	
	
}
