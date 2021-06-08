package ar.edu.unju.fi.tp8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp8.model.Compra;
import ar.edu.unju.fi.tp8.servicee.ICompraService;
import ar.edu.unju.fi.tp8.servicee.IProductoService;






@Controller
public class CompraController {

	@Autowired
	private Compra compra;
	
	@Autowired
	@Qualifier("productoServiceMySql")
	private IProductoService productoService;
	
	
	@Autowired
	@Qualifier("compraServiceMySql")
	private ICompraService compraService;
	
	
	@GetMapping("/compra/nuevo")
	public String getCompraPage(Model model) {
		model.addAttribute("compra",compra);
		model.addAttribute("productos", productoService.getAllProductos());
		return "compra";
	}
	
	@PostMapping("/compra/guardar")
	   public ModelAndView getGuardarCompraPage(@ModelAttribute("compra")Compra compra) {
		ModelAndView modelView = new ModelAndView("compra");
		 compraService.addCompra(compra);
		modelView.addObject("compra",compraService.getAllCompras());
		return modelView;
	
	}
	@GetMapping("/compra/listado")
	 public String getComprasPage(Model model) {
		 model.addAttribute("compras",compraService.getAllCompras());
		 return "clientes";
	 }
	
	
	
	
	
}
