package ar.edu.unju.fi.tp8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp8.model.Compra;
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
	
	
	
	@GetMapping("/producto")
	public String getProductoFormPage(Model model){
	model.addAttribute("producto", productoService.getProducto());
    //lista para agregar compras
	
	List<Compra> compras = compraService.getAllCompras();
	model.addAttribute("compras",compras);
	
	
	return "nuevo";
	}
	@PostMapping("/producto/guardar")
	
	
	public ModelAndView getProductogPage(@ModelAttribute("producto")Producto producto) {
		 ModelAndView modelView = new ModelAndView("productos");
		 productoService.addProducto(producto);
		modelView.addObject("productos",productoService.getAllProductos());
		return modelView;
	}
	
}