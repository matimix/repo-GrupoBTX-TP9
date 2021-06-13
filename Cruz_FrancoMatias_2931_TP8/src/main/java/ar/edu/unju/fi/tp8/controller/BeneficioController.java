package ar.edu.unju.fi.tp8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp8.model.Beneficio;
import ar.edu.unju.fi.tp8.model.Cliente;
import ar.edu.unju.fi.tp8.servicee.IBeneficioService;
import ar.edu.unju.fi.tp8.servicee.IClienteService;



@Controller
public class BeneficioController {

	@Autowired
	Beneficio beneficio;
	
	@Autowired
	Cliente cliente;
	
	
	@Autowired
	@Qualifier("clienteServiceMySql")
	IClienteService  clienteService;
	
	@Autowired
	@Qualifier("beneficioServiceMySql")
	IBeneficioService  beneficioService;
	
	
	@GetMapping("/beneficio/nuevo")
         public String getProyectoNuevoPage(Model model) {
        	 model.addAttribute("beneficio",beneficio);
        	 model.addAttribute("cliente",cliente);
        	 model.addAttribute("clientesEncontrados",clienteService.obtenerClientesEncontrados());
             return "lista-clientes";
	      }
	
	@PostMapping("/beneficio/guardar")
	public ModelAndView guardarBeneficio(@ModelAttribute("beneficio") Beneficio beneficio,@ModelAttribute("cliente") Cliente cliente){
		ModelAndView modelView = new ModelAndView("lista-beneficio");
		//recuperar la lista de los clientes q fueron seleccionados para trabajar en este proy
		beneficio.setClientes(clienteService.obtenerClientesEncontrados());
	    beneficioService.guardarBeneficio(beneficio);
	   
		
    	 
	   return modelView;
	}
	
	
	@GetMapping("/beneficio/listar")
	   public ModelAndView getListaBeneficiosPage() {
		   ModelAndView modelView = new ModelAndView("lista-beneficio");
		   modelView.addObject("beneficios", beneficioService.getAllBeneficios());
		   return modelView;
		
	}
}
