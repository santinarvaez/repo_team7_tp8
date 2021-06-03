package ar.edu.unju.fi.tp4.service;


import java.util.List;
import java.util.Optional;
import ar.edu.unju.fi.tp4.model.Producto;

public interface IProductoService {

	public void addProducto(Producto producto);
	public Producto getUltimoProducto();
	public Producto getProducto();
	public List<Producto> getAllProductos();
	public void generarTablaProductos();
	public Producto getProductoForCodigo(int codigo);
	public Optional<Producto> getProductoForId(Long id);
	public void eliminarProducto(Long id);
	

}
