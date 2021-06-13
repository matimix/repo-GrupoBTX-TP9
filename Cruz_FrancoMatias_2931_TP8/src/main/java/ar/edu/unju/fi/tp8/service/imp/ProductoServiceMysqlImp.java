package ar.edu.unju.fi.tp8.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Producto;
import ar.edu.unju.fi.tp8.repository.IProductoRepository;
import ar.edu.unju.fi.tp8.servicee.IProductoService;






@Service("productoServiceMySql")
public class ProductoServiceMysqlImp implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;
	
	
	@Override
	public void addProducto(Producto producto) {
		 productoRepository.save(producto);
		
	}

	@Override
	public Producto getUltimoProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto getProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getAllProductos() {
		List<Producto> productos = (List<Producto>) productoRepository.findAll();
		return productos;
	}

	@Override
	public Producto getProductoporCodigo(long codigo) {
		Producto producto = productoRepository.findByCodigo(codigo);
		return producto;
	}

	@Override
	public void tablaProductos() {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
