package es.upm.dit.isst.icare.dao;

import java.util.List;

import es.upm.dit.isst.icare.model.Pacientes;

public interface PacientesDAO {


	List<Pacientes> listPacientes();

	Pacientes readId(String id);

	void delete(String idStr);


	Pacientes readId(Long idl);

	Pacientes create(String nombre, String apellidos, String dNI, String nUSS, int edad, String nacimiento, String dir,
			String ciudad, int cp, String estadocivil, String enf, String disc, String vivesolo, String nombrecuid,
			String apellcuid, String tlfcuid, String nombrefam, String apellfam, String tlffam, int agua);

}