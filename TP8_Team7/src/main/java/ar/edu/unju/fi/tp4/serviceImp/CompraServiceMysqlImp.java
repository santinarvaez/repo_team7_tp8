package ar.edu.unju.fi.tp4.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.service.ICompraService;
import ar.edu.unju.fi.tp4.repository.ICompraRepository;

@Service("compraMysql")
public class CompraServiceMysqlImp implements ICompraService {
	
	@Autowired
	private Compra compra;
	
	@Autowired
	private ICompraRepository compraRepository;

	@Override
	public void generarTablaCompras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarCompra(Compra compra) {
		compraRepository.save(compra);
		
	}
	
	@Override
	public Compra getCompra() {
		return compra;
	}

	@Override
	public List<Compra> getCompras() {
		List<Compra> compras = (List<Compra>) compraRepository.findAll();
		return compras;
	}

	@Override
	public Compra consultarUltimaCompra() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Compra> getCompraPorId(Long id) {
		Optional<Compra> compra = compraRepository.findById(id);
		return compra;
	}
	
	@Override
	public void eliminarCompra(Long id) {
		compraRepository.deleteById(id);
	}

	@Override
	public List<Compra> buscarCompras(String nombre, double total) {
		
		List<Compra> compras = new ArrayList<Compra>();
		if(!nombre.isEmpty() && total >= 0) {
			compras = compraRepository.findByProductoNombreAndTotalGreaterThanEqual(nombre, total);
		}else if(nombre.isEmpty() && total >= 0){
			compras = compraRepository.findByTotalGreaterThanEqual(total);
		}
		return compras;
	}
}
	

