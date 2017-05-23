package es.upm.dit.isst.icare.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import es.upm.dit.isst.icare.model.Recursos;

public class RecursosDAOImpl implements RecursosDAO{
	
private static RecursosDAOImpl instancia;
	
	private RecursosDAOImpl(){
			
	}
	
	public static RecursosDAOImpl getInstancia(){
		if (instancia == null)
				instancia = new RecursosDAOImpl();
		return instancia;
	}
	
	@Override
	public Recursos create (String locAlarma, String locRecurso, double latitud, double altitud, int telf, String tipo){
		Recursos recurso = new Recursos (locAlarma, locRecurso, latitud, altitud, telf, tipo);
		ofy().save().entity(recurso).now();
		return recurso;
	}
	
	@Override
	public List<Recursos> readAlarmResource(String locAlarma) {

		return ofy().load().type(Recursos.class).filter("locAlarma", locAlarma).list();
	}

}
