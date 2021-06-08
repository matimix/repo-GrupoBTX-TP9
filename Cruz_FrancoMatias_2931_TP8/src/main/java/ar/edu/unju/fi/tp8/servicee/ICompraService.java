package ar.edu.unju.fi.tp8.servicee;
import java.util.List;

import ar.edu.unju.fi.tp8.model.Compra;



public interface ICompraService {
	
	public void addCompra(Compra compra);
	public void guardarCompra(Compra compra);
	public List <Compra> getAllCompras();
	

}
