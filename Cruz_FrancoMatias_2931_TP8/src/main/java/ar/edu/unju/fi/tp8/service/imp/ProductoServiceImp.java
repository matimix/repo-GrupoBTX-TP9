package ar.edu.unju.fi.tp8.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Compra;
import ar.edu.unju.fi.tp8.model.Producto;
import ar.edu.unju.fi.tp8.servicee.IProductoService;



@Service("productoServiceSimple")
public class ProductoServiceImp implements IProductoService{

	@Autowired
	Producto producto;
	
	@Autowired
	Compra compra;
	
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
	List<Producto> productos = new ArrayList<Producto>();
	/*
	public ProductoServiceImp() {
		Producto e1 = new Producto(22,"carne",22,"carnita",2, null);
		Producto e2 = new Producto(11,"leche",11,"milk",33, null);
				
		this.productos.add(e1);
		this.productos.add(e2);
		
	}
	*/
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

	@Override
	public void tablaProductos() {
		//productos = ar.edu.unju.fi.tp5.util.TablaProductos.tablaProductos;
		LOGGER.info("METHOD: generarTablaClientes ---- Se genero la tabla de productos");
		
	}

	
	
}
