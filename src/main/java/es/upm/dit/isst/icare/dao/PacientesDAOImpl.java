package es.upm.dit.isst.icare.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;


import java.util.List;


import com.googlecode.objectify.Key;

import es.upm.dit.isst.icare.model.Pacientes;

public class PacientesDAOImpl implements PacientesDAO {

	private static PacientesDAOImpl instance;
	
	private PacientesDAOImpl() {
	}
	
	public static PacientesDAOImpl getInstance(){
		if (instance == null){
			instance = new PacientesDAOImpl();
		}
		return instance;
	}
	

	@Override
	public Pacientes create(String nombre, String apellidos, String dNI, String nUSS, int edad, String nacimiento,
			String dir, String ciudad, int cp, String estadocivil, String enf, String disc, String vivesolo,
			String nombrecuid, String apellcuid, String tlfcuid, String nombrefam, String apellfam, String tlffam, int agua) {
			
		Pacientes paciente = new Pacientes (nombre, apellidos, dNI, nUSS, edad, nacimiento, dir, ciudad, cp, estadocivil, enf, disc, vivesolo, nombrecuid, apellcuid, tlfcuid, nombrefam, apellfam, tlffam, agua);
		
		ofy().save().entity(paciente).now();
		return paciente;
		
	}
	
	@Override
	public List<Pacientes> listPacientes() {
		
		return ofy().load().type(Pacientes.class).list();
	
	}
	
	@Override
	public Pacientes readId (Long idl){
		return ofy().load().type(Pacientes.class).filterKey(Key.create(Pacientes.class, idl)).first().now();
	}
	@Override
	public Pacientes readId (String idl){
		Long id = Long.parseLong(idl);
		return ofy().load().type(Pacientes.class).filterKey(Key.create(Pacientes.class, id)).first().now();
	}
	
	
	@Override
	public void delete (String id){
		Long idl = Long.parseLong(id);
		ofy().delete().type(Pacientes.class).id(idl).now();
	}

	
}