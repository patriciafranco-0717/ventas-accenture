package co.accenture.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ventas")
public class Venta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime fecha;

	private Double total;
	
	private Double subtotal;
	
	private Double domicilio;
	
	private Float iva;
	
	@JsonIgnoreProperties(value={"ventas", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_venta")
	private List<Detalle> detalles;

	@PrePersist
	public void prePersist() {
		fecha = LocalDateTime.now();
	}
	
	public Venta() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	 * @return the subtotal
	 */
	public Double getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
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
	 * @return the detalles
	 */
	public List<Detalle> getDetalles() {
		return detalles;
	}

	/**
	 * @param detalles the detalles to set
	 */
	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	/**
	 * @return the iva
	 */
	public Float getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(Float iva) {
		this.iva = iva;
	}	
		
}
