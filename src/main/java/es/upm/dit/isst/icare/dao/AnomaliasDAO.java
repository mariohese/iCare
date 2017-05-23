package es.upm.dit.isst.icare.dao;

import java.util.Date;
import java.util.List;

import es.upm.dit.isst.icare.model.Anomalias;
import es.upm.dit.isst.icare.model.Pacientes;

public interface AnomaliasDAO {

	
	List<Anomalias> listAnomalias();
	
	void remove(long id);

	List<Anomalias> readPacientAnomalies(String id);

	Anomalias create(Anomalias anomalia);


}