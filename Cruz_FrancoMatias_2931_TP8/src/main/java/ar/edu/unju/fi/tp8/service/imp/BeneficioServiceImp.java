package ar.edu.unju.fi.tp8.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp8.model.Beneficio;
import ar.edu.unju.fi.tp8.repository.IBeneficioRepository;
import ar.edu.unju.fi.tp8.servicee.IBeneficioService;



@Service("beneficioServiceMySql")
public class BeneficioServiceImp implements IBeneficioService {
	@Autowired
	
	IBeneficioRepository beneficioRepository;
	
	@Override
	public void guardarBeneficio(Beneficio beneficio) {
		beneficioRepository.save(beneficio);
		
	}

	@Override
	public List<Beneficio> getAllBeneficios() {
		 List <Beneficio> lista = (List<Beneficio>) beneficioRepository.findAll();
			return lista;
	}

}
