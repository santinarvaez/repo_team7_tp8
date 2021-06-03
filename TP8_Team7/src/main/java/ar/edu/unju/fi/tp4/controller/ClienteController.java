package ar.edu.unju.fi.tp4.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.service.IClienteService;
import ar.edu.unju.fi.tp4.service.ICuentaService;


@Controller
public class ClienteController {
	
	@Autowired
	@Qualifier("clienteMysql")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("cuentaMysql")
	private ICuentaService cuentaService;
	
	@GetMapping("/cliente/nuevo")
	public String getNuevoCliente(Model model) {
		model.addAttribute("cliente", clienteService.getCliente()); 
		return "nuevocliente";
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView guardarClientePage(@ModelAttribute("cliente")Cliente cliente) {
		ModelAndView model = new ModelAndView("clientes");
		clienteService.guardarCliente(cliente);
		model.addObject("clientes", clienteService.getClientes());
		return model;
	}
	
	@GetMapping("/cliente/listado")
	public ModelAndView getListadoPage() {
		ModelAndView model = new ModelAndView("clientes");
		if(clienteService.getClientes() == null)
			clienteService.generarTablaClientes();
		model.addObject("clientes", clienteService.getClientes());
		return model;
	}
	
	@GetMapping("/cliente/editar/{id}")
	public ModelAndView getEditClientePage(@PathVariable(value = "id")Long id) {
		ModelAndView model = new ModelAndView("nuevocliente");
		Optional<Cliente> cliente = clienteService.getClienteForId(id);
		model.addObject("cliente", cliente);
		return model;
	}
	
	@GetMapping("/cliente/eliminar/{id}")
	public ModelAndView getProductoEliminar(@PathVariable(value = "id")Long id) {
		ModelAndView model = new ModelAndView("redirect:/cliente/listado");
		clienteService.eliminarCliente(id);
		return model;
	}
}
