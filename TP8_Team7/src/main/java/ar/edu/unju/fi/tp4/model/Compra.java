package ar.edu.unju.fi.tp4.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "COMPRAS")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Min(value = 1,message = "Ingrese un valor mayor a 1")
	@Column(name = "comp_codigo")
	private Long codigo;
	
	@Min(value = 1,message = "Ingrese un valor mayor a 1")
	@Column(name = "comp_cantidad")
	private int cantidad;
	
	//Método se calcula en el controller solo, no necesita restricción.
	@Column(name = "comp_total")
	private double total;
	
	@OneToMany(mappedBy = "compra")
	private List<Producto> productos = new ArrayList<Producto>();
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prod_id")
	private Producto producto;
	
	public Compra() {
		super();
	}

	

	public Compra(Long id, @Min(value = 1, message = "Ingrese un valor mayor a 1") Long codigo,
			@Min(value = 1, message = "Ingrese un valor mayor a 1") int cantidad, double total,
			List<Producto> productos, Producto producto) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.total = total;
		this.productos = productos;
		this.producto = producto;
	}



	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		double total = this.cantidad*this.producto.getPrecio();
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	
	
}

