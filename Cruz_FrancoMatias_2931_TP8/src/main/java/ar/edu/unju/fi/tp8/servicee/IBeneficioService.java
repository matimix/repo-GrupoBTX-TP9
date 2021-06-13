package ar.edu.unju.fi.tp8.servicee;

import java.util.List;

import ar.edu.unju.fi.tp8.model.Beneficio;




public interface IBeneficioService {
	public void guardarBeneficio(Beneficio beneficio);
    public List <Beneficio> getAllBeneficios();
}
