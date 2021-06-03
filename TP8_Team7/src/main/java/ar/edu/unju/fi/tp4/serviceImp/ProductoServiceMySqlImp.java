package ar.edu.unju.fi.tp4.serviceImp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.repository.IProductoRepository;
import ar.edu.unju.fi.tp4.service.IProductoService;

@Service("productoMysql")
public class ProductoServiceMySqlImp implements IProductoService{
	
	@Autowired
	private IProductoRepository productoRepository;

	
	@Override
	public void addProducto(Producto producto) {
		productoRepository.save(producto);
	}
	

	@Override
	public Producto getUltimoProducto() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Producto getProducto() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Producto> getAllProductos() {
		List<Producto> productos = (List<Producto>) productoRepository.findAll();
		return productos;
	}

	@Override
	public void generarTablaProductos() {
	}
	

	@Override
	public Producto getProductoForCodigo(int codigo) {
		Producto producto = productoRepository.findByCodigo(codigo);
		return producto;
	}

	
	@Override
	public Optional<Producto> getProductoForId(Long id) {
		Optional<Producto> producto = productoRepository.findById(id);
		return producto;
	}

	
	@Override
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
	}
	
	

	
}
