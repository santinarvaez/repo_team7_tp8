package ar.edu.unju.fi.tp4.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;


@Controller
public class ProductoController {
	
	//private static final Log LOGGER = LogFactory.getLog(ProductoController.class);

	@Autowired
	@Qualifier("productoMysql")
	private IProductoService productoService ;
	
	@Autowired
	private Producto producto;

	
	@GetMapping("/producto/nuevo")
	public String getProductoPage(Model model) {
		model.addAttribute(producto);
		return "nuevoProducto";
	}
	
	@PostMapping("/producto/guardar")
	public ModelAndView guardarProducto(@Valid @ModelAttribute("producto") Producto producto,BindingResult resultadoValidacion) {
		ModelAndView modelView;
		if(resultadoValidacion.hasErrors()==true) {
			modelView = new ModelAndView("nuevoProducto");
			return modelView;
		}else {
			modelView = new ModelAndView("lista-producto");
			productoService.addProducto(producto);
			modelView.addObject("producto",productoService.getAllProductos());
			return modelView;
		}		
	}
	
	@GetMapping("/producto/listado")
	public ModelAndView getListadoPage() {
		ModelAndView model = new ModelAndView("lista-producto");
		if(productoService.getAllProductos() == null)
			productoService.generarTablaProductos();
		model.addObject("producto", productoService.getAllProductos());
		return model;
	}
	

	@GetMapping("/producto/editar/{id}")
	public ModelAndView getProductoEditPage(@PathVariable(value = "id") Long id) {
		ModelAndView modelView = new ModelAndView("nuevoProducto");
		Optional<Producto> producto = productoService.getProductoForId(id);
		modelView.addObject("producto",producto);
		return modelView;
	}
	
	@GetMapping("/producto/eliminar/{id}")
	public ModelAndView getProductoEliminar(@PathVariable(value = "id") Long id){
		ModelAndView modelView = new ModelAndView("redirect:/producto/listado");
		productoService.eliminarProducto(id);
		return modelView;
	}
	
	
}
