package es.upm.dit.isst.icare.dao;

import java.util.List;

import es.upm.dit.isst.icare.model.*;

public interface LoginDAO {

	public Login create (String user, String psswd);
	public List <Login> read();
	public Login readUser(String user);
	void delete(String id);
	
}
