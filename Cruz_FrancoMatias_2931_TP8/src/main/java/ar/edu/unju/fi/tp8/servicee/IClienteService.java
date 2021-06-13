package ar.edu.unju.fi.tp8.servicee;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp8.model.Cliente;







public interface IClienteService {

	public void addCliente(Cliente cliente);
	
	public Cliente getUltimoCliente();
	
	public Cliente getCliente();
	
	public List<Cliente> getAllClientes();
	
	public Cliente getClientePordni(int dni);
	
	public Optional<Cliente> getClientePorId(Long id);
	
	public void eliminarCliente(Long id);
	
	
	//nuevo para compra
	public List<Cliente> buscarClientes(String nombre, int dni);
	//nuevo
	//guardar clientes asociados a proyecto
	public List<Cliente> obtenerClientesEncontrados();
	
	
	public void agregarClienteEncontrado(Cliente cliente);
	
	public void quitarClienteLista(Long id);
	
}
