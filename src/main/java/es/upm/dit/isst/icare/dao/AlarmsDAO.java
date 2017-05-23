package es.upm.dit.isst.icare.dao;

import java.util.Date;
import java.util.List;

import es.upm.dit.isst.icare.model.Alarms;
import es.upm.dit.isst.icare.model.Pacientes;

public interface AlarmsDAO {

	public List<Alarms> listAlarms();
	List<Alarms> readPacientAlarms(String idl);
	void delete(long id);
	
	Alarms readAlarmById(String idl);
	Alarms update(Alarms alarm);
	Alarms create(Pacientes paciente, String descripcion, String estado, String usuario, int nivel, String decision,
			Date fecha, String localizacion, double altitud, double latitud);
	Alarms create(Alarms alarm);

}
