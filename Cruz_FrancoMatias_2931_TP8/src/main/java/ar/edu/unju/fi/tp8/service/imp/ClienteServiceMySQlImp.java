package ar.edu.unju.fi.tp8.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Cliente;
import ar.edu.unju.fi.tp8.repository.IClienteRepository;
import ar.edu.unju.fi.tp8.servicee.IClienteService;



@Service("clienteServiceMySql")
public class ClienteServiceMySQlImp implements IClienteService {

	@Autowired
	private Cliente cliente;
	
	
	
	
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	
	
	
	@Override
	public void addCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public Cliente getUltimoCliente() {
		return null;
	}

	@Override
	public Cliente getCliente() {
		
		return cliente;
	}

	@Override
	public List<Cliente> getAllClientes() {
		List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
		return clientes;
	}

	@Override
	public Cliente getClientePordni(int dni) {
		Cliente cliente = clienteRepository.findByDni(dni);
		return cliente;
	}

	@Override
	public Optional<Cliente> getClientePorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente;
	}

	@Override
	public void eliminarCliente(Long id) {
		clienteRepository.deleteById(id);
		
	}
	
	

}
