package es.upm.dit.isst.icare.dao;

import java.util.Date;
import java.util.List;

import es.upm.dit.isst.icare.model.Pacientes;
import es.upm.dit.isst.icare.model.Sensores;

public interface SensoresDAO {

	List<Sensores> readPacientSensores(String idl);

	Sensores create(Sensores sensor);

	void remove(long id);

	Sensores create(Pacientes paciente, Long idPaciente, Date fecha, int pulsometro, double azucar, double oxigeno,
			int tension_sist, int tension_diast, double consumo_agua, double acelerometro, double cO,
			double temperatura, double co2);

}
