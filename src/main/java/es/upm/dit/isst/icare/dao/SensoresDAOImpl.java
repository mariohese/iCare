package es.upm.dit.isst.icare.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.Date;
import java.util.List;

import es.upm.dit.isst.icare.model.Pacientes;
import es.upm.dit.isst.icare.model.Sensores;

public class SensoresDAOImpl implements SensoresDAO{
	
	private static SensoresDAOImpl instancia;
	
	private SensoresDAOImpl(){
			
	}
	
	public static SensoresDAOImpl getInstancia(){
		if (instancia == null)
				instancia = new SensoresDAOImpl();
		return instancia;
	}
	
	@Override
	public Sensores create (Pacientes paciente, Long idPaciente, Date fecha, int pulsometro, double azucar,
			double oxigeno, int tension_sist, int tension_diast, double consumo_agua, double acelerometro, double cO,
			double temperatura, double co2){
		Sensores sensor = new Sensores (paciente, idPaciente, fecha, pulsometro, azucar,
			oxigeno, tension_sist, tension_diast, consumo_agua, acelerometro, cO,
			temperatura, co2);
		ofy().save().entity(sensor).now();
		return sensor;
	}
	
	@Override
	public Sensores create(Sensores sensor){
		ofy().save().entity(sensor).now();
		return sensor;
	}
	
	@Override
	public List<Sensores> readPacientSensores(String idl) {

		Long id = Long.parseLong(idl);
		return ofy().load().type(Sensores.class).filter("idPaciente", id).list();
	}
	
	@Override
	public void remove(long id) {
		
		ofy().delete().type(Sensores.class).id(id).now();
	

	}

}
