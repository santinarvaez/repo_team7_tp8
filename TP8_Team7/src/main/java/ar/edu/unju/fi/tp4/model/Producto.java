package ar.edu.unju.fi.tp4.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTOS")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Long id;
	
	@Min(value = 1,message="Ingrese un valor mayor a 1")
	@Column(name="prod_codigo", nullable = false)
	private int codigo;
	
	@NotEmpty(message = "Este campo debe ser completado")
	@Size(min=5,max=40,message="El nombre debe tener como mínimo 5 caracteres")
	@Column(name="prod_nombre")
	private String nombre;
	
	@Min(value=0,message="Debe ingresar un valor mayor a 0")
	@Column(name="prod_precio")
	private double precio;
	
	@NotEmpty(message = "Este campo debe ser completado")
	@Size(min=3,max=40,message="El nombre debe tener como mínimo 3 caracteres")
	@Column(name="prod_marca")
	private String marca;
	
	@Min(value=0,message="Debe ingresar un valor mayor a 0")
	@Column(name="prod_stock")
	private int stock;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comp_id")
	private Compra compra;
	
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(Long id, int codigo, String nombre, double precio, String marca, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
