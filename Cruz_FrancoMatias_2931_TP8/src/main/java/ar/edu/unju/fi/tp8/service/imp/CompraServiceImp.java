package ar.edu.unju.fi.tp8.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Compra;
import ar.edu.unju.fi.tp8.servicee.ICompraService;
import ar.edu.unju.fi.tp8.util.TablaCompra;




/**
 * aqui va el cuerpo de los metodos
 * @author Familia
 *
 */

@Service("compraServiceSimple")
public class CompraServiceImp implements ICompraService {

	
	@Autowired
	Compra compra;
	
	
	
	List<Compra> compras = TablaCompra.compras;
	
	@Override
	public void addCompra(Compra compra) {
		this.compras.add(compra);
		
	}

	@Override
	public List<Compra> getAllCompras() {
		return this.compras;
	}

	

	@Override
	public Compra getCompra() {
		this.compra.setId(11);
		return this.compra;
	}

	@Override
	public List<Compra> buscarCompras(String nombre, double total) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
