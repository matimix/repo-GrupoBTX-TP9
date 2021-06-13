package ar.edu.unju.fi.tp8.service.imp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Cliente;
import ar.edu.unju.fi.tp8.servicee.IClienteService;







@Service("clienteServiceSimple")
public class ClienteServiceImp implements IClienteService {

	@Autowired
	Cliente cliente;
	
	List<Cliente> clientes = new ArrayList<Cliente>();
	
	
//agregar manuales usuarios
	
	
	
	
	
	@Override
	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
		
	}

	@Override
	public Cliente getUltimoCliente() {
		int indiceUltimoElemento = clientes.size()-1;
		Cliente cliente = clientes.get(indiceUltimoElemento);
		return cliente;
	}

	@Override
	public Cliente getCliente() {
		this.cliente.setDni(22221);;
		return this.cliente;
	}

	@Override
	public List<Cliente> getAllClientes() {
		return this.clientes;
	}

	@Override
	public Cliente getClientePordni(int dni) {
		Cliente clie = new Cliente();
		for(Cliente cl: clientes) {
			
			if(cl.getDni()== dni){
				clie = cl;
			}
		}
		return clie;
	}

	@Override
	public Optional<Cliente> getClientePorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCliente(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> buscarClientes(String nombreApellido, int dni) {
		// TODO Auto-generated method stub
		return null;
	}

	//nuevo pero no se usa tanto
	@Override
	public List<Cliente> obtenerClientesEncontrados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarClienteEncontrado(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitarClienteLista(Long id) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}