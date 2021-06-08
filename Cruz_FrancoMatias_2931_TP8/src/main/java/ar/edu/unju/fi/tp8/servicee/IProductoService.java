package ar.edu.unju.fi.tp8.servicee;
import java.util.List;

import ar.edu.unju.fi.tp8.model.Producto;



public interface IProductoService {

	/**
	 * aqui van solo los nombres de los metodos
	 */
	public void addProducto(Producto producto);
	
	public Producto getUltimoProducto();
	
	public Producto getProducto();
	
	public List<Producto> getAllProductos();
	
	public Producto getProductoporCodigo(long codigo);
	
	
	
}
