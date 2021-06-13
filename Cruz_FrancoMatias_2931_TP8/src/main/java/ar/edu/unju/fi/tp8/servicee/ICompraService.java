package ar.edu.unju.fi.tp8.servicee;
import java.util.List;

import ar.edu.unju.fi.tp8.model.Compra;





public interface ICompraService {
	
	public void addCompra(Compra compra);
	public List <Compra> getAllCompras();
	public Compra getCompra();
	public List<Compra> buscarCompras(String nombre, double total);
}
