package es.upm.dit.isst.icare.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;


import es.upm.dit.isst.icare.model.Anomalias;

public class AnomaliasDAOImpl implements AnomaliasDAO {

	private static AnomaliasDAOImpl instance;
	
	private AnomaliasDAOImpl() {
	}
	
	public static AnomaliasDAOImpl getInstance(){
		if (instance == null){
			instance = new AnomaliasDAOImpl();
		}
		return instance;
	}

	
	@Override
	public Anomalias create(Anomalias anomalia){
		ofy().save().entity(anomalia).now();
		return anomalia;
	}
	
	@Override
	public List<Anomalias> listAnomalias() {
		
		return ofy().load().type(Anomalias.class).list();
		
	}
	
	@Override
	public List<Anomalias> readPacientAnomalies(String idl) {

		Long id = Long.parseLong(idl);
		return ofy().load().type(Anomalias.class).filter("idPaciente", id).list();
	}
	
	@Override
	public void remove(long id) {
		
		ofy().delete().type(Anomalias.class).id(id).now();
	

	}
	

	
	
	
	
	
	
}