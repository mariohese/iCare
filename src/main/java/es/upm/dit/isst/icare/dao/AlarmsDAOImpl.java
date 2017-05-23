package es.upm.dit.isst.icare.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;


import java.util.Date;
import java.util.List;

import com.googlecode.objectify.Key;

import es.upm.dit.isst.icare.model.Alarms;
import es.upm.dit.isst.icare.model.Pacientes;


public class AlarmsDAOImpl implements AlarmsDAO {

	//Solo puede haber un objeto de esta clase en la aplicación, porque si tenemos
	//varios de ellos las operaciones de acceso a la base de datos pueden no dejar
	//resultados consistentes
	
	private static AlarmsDAOImpl instancia;
	
	private AlarmsDAOImpl(){
		
	}
	
	public static AlarmsDAOImpl getInstancia(){
		if (instancia == null)
				instancia = new AlarmsDAOImpl();
		return instancia;
	}

	@Override
	public Alarms create(Pacientes paciente, String descripcion, String estado, String usuario, int nivel, String decision, Date fecha, String localizacion, double altitud, double latitud) {
			
		Alarms alarm = new Alarms (paciente, descripcion, estado, usuario, nivel, decision, fecha, localizacion, altitud, latitud);
		ofy().save().entity(alarm).now();
		return alarm;
		
	}
	
	@Override
	public Alarms create(Alarms alarm){
		ofy().save().entity(alarm).now();
		return alarm;
	}
	
	@Override
	public List<Alarms> listAlarms() {
		
		return ofy().load().type(Alarms.class).list();
		
	}
	
	@Override
	public Alarms readAlarmById (String idl){
		Long id = Long.parseLong(idl);
		return ofy().load().type(Alarms.class).filterKey(Key.create(Alarms.class, id)).first().now();
		
	}
	
	@Override
	public List<Alarms> readPacientAlarms(String idl) {

		Long id = Long.parseLong(idl);
		return ofy().load().type(Alarms.class).filter("idPaciente", id).list();
	}
	
	@Override
	public Alarms update(Alarms alarm){
		ofy().save().entity(alarm).now();
		return alarm;
	}
	
	
	@Override
	public void delete(long id) {
		
		ofy().delete().type(Alarms.class).id(id).now();

	}
	
	
	

	
	
}