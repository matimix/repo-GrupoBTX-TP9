package ar.edu.unju.fi.tp8.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp8.model.Producto;
import ar.edu.unju.fi.tp8.servicee.ICompraService;
import ar.edu.unju.fi.tp8.servicee.IProductoService;







@Controller
public class ProductoController {
	
	@Autowired
	@Qualifier("productoServiceMySql")
	 IProductoService productoService;
	
	@Qualifier("compraServiceMySql")
	 ICompraService compraService;
	
	
	@Autowired
	private Producto producto;
	
	
	
	
	
	
	@GetMapping("/nuevo/producto")
	public String getProductoFormPage(Model model){
	model.addAttribute(producto);
    return "nuevo-producto";
	}
	@PostMapping("/producto/guardar")
	/*
	public ModelAndView getProductogPage(@ModelAttribute("producto")Producto producto) {
		 ModelAndView modelView = new ModelAndView("producto");
		 productoService.addProducto(producto);
		//modelView.addObject("productos",productoService.getAllProductos());
		 return modelView;
	}
	*/
	public ModelAndView guardarProductoPage(@Valid @ModelAttribute("producto") Producto producto, BindingResult Validacion) {
		ModelAndView modelView;
		if(Validacion.hasErrors()) {
			modelView = new ModelAndView("nuevo-producto");
			return modelView;
		}
		else {
			productoService.addProducto(producto);
			modelView = new ModelAndView("nuevo-producto");
			return modelView;
		}
	}
	
	@GetMapping("/producto/listado")
	public ModelAndView getListadoPage() {
		ModelAndView modelView = new ModelAndView("lista-productos");
		productoService.tablaProductos();
		modelView.addObject("productos", productoService.getAllProductos());
		return modelView;
	}
	
}