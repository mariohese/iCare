package es.upm.dit.isst.icare.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import es.upm.dit.isst.icare.model.Login;

public class LoginDAOImpl implements LoginDAO {

	private static LoginDAOImpl instancia;
	
	private LoginDAOImpl (){
		
	}
	
	public static LoginDAOImpl getInstancia(){
		if (instancia == null)
			instancia= new LoginDAOImpl();
		return instancia;
	}
	
	@Override
	public Login create (String user, String psswd){
		Login login = new Login (user, psswd);
		ofy().save().entity(login).now();
		return login;
	}
	
	
	@Override
	public List <Login> read(){
		return ofy().load().type(Login.class).list();
	}
	
	@Override
	public Login readUser(String user) {
		return ofy().load().type(Login.class).filter("user", user).first().now();
	}
	
	@Override
	public void delete(String id){
		Long idl = Long.parseLong(id);
		ofy().delete().type(Login.class).id(idl).now();
	}
	
}
