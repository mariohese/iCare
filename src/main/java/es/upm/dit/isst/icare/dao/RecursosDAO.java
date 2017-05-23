package es.upm.dit.isst.icare.dao;

import java.util.List;

import es.upm.dit.isst.icare.model.Recursos;

public interface RecursosDAO {

	List<Recursos> readAlarmResource(String locAlarma);

	Recursos create(String locAlarma, String locRecurso, double latitud, double altitud, int telf, String tipo);

}
