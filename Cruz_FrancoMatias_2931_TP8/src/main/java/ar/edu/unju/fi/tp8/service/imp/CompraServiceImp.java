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

	List<Compra> compras = TablaCompra.compras;
	
	@Override
	public void guardarCompra(Compra compra) {
		compras.add(compra);
		
	}

	@Override
	public List<Compra> getAllCompras() {
		return compras;
	}

	@Override
	public void addCompra(Compra compra) {
		// TODO Auto-generated method stub
		
	}
	

}
