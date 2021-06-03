package ar.edu.unju.fi.tp4.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.repository.IClienteRepository;
import ar.edu.unju.fi.tp4.service.IClienteService;

@Service("clienteMysql")
public class ClienteServiceMySqlImp implements IClienteService {


	@Autowired
	private Cliente cliente;
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	public void generarTablaClientes() {
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public List<Cliente> getClientes() {
		List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
		return clientes;
	}
	
	@Override
	public Cliente getClientePorDni(int nroDocumento) {
		return null;
	}

	@Override
	public Cliente getCliente() {
		return cliente;
	}
	
	@Override
	public Optional<Cliente> getClienteForId(Long id) {
		Optional <Cliente> cliente = clienteRepository.findById(id);
		return cliente;
	}

	@Override
	public void eliminarCliente(Long id) {
		clienteRepository.deleteById(id);
		
	}


}
