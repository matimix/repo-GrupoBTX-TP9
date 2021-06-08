package ar.edu.unju.fi.tp8.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Producto;
import ar.edu.unju.fi.tp8.servicee.IProductoService;




/**
 * aqui va el cuerpo completo de los metodos que utilizo
 * @author matia
 *
 */

@Service("productoServiceSimple")
public class ProductoServiceImp implements IProductoService{

	@Autowired
	Producto producto;
	
	List<Producto> productos = new ArrayList<Producto>();
	
	public ProductoServiceImp() {
		Producto e1 = new Producto(22,"carne",22,"carnita",2);
		Producto e2 = new Producto(11,"leche",11,"milk",33);
				
		this.productos.add(e1);
		this.productos.add(e2);
		
	}
	
	@Override
	public void addProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.productos.add(producto);
	}

	@Override
	public Producto getUltimoProducto() {
		// TODO Auto-generated method stub
		int indiceUltimoElemento = productos.size() - 1;
		Producto producto = productos.get(indiceUltimoElemento); 
		return producto;
	}
	
	@Override
	public Producto getProducto() {
		this.producto.setCodigo(1234);
		return this.producto;
		
		
	}

	

	@Override
	public List<Producto> getAllProductos() {
		return this.productos;
	}

	@Override
	public Producto getProductoporCodigo(long codigo) {
		Producto produ = new Producto();
		for(Producto pro: productos) {
			if(pro.getCodigo() == codigo) {
				 produ = pro;
			}
		}
	return produ;
	}

	
	
}
