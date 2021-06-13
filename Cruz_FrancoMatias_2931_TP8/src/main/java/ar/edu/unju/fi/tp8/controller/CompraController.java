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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp8.model.Compra;
import ar.edu.unju.fi.tp8.model.Producto;
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
		model.addAttribute("compra", compra);
		model.addAttribute("productos",productoService.getAllProductos());
		return "nueva-compra";
		}
	
	@PostMapping("/compra/guardar")
	public ModelAndView guardarCompra(@Valid @ModelAttribute("compra")Compra compra,BindingResult resultadoValid) {
		 ModelAndView modelView = new ModelAndView("compra");
		 if(resultadoValid.hasErrors()){ // si tiene errores
			 modelView = new ModelAndView("nueva-compra");
				modelView.addObject("productos", productoService.getAllProductos());
				//System.out.println(compra);
				return modelView;
			} else 
		 { //no hay errores
				modelView = new ModelAndView("nueva-compra");
				Producto producto = productoService.getProductoporCodigo(compra.getProducto().getCodigo());
				compra.setProducto(producto);
				compra.setTotal(compra.getCantidad()*producto.getPrecio());
				compraService.addCompra(compra);
				modelView.addObject("nueva-compra", compraService.getAllCompras());
				return modelView;
	     } 
	}
	
	
	@GetMapping("/compra/listado")
	public String getCompraPAGE(Model model) {
		 model.addAttribute("compra",compraService.getCompra());
		 model.addAttribute("compras",compraService.getAllCompras());
		 return "lista-compra";
	 }
	
	@GetMapping("/compra/busqueda")

    public String buscarCompraPorFiltro(@RequestParam(name="nombre") String nombre, @RequestParam(name="total") double total,Model model, @ModelAttribute(name="compra") Compra compra) {
	           model.addAttribute("compra",compraService.getCompra());
              model.addAttribute("compras",compraService.buscarCompras(nombre,total));
         return "lista-compra";       
  }
	
	
	
}
