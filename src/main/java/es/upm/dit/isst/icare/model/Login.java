package es.upm.dit.isst.icare.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.googlecode.objectify.annotation.*;

@Entity
public class Login implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Index
	private String user;
	@Index
	private String passwd;
	
	public Login (){

	}
	
	public Login (String user, String passwd){
		this.user = user;
		this.passwd = passwd;
	}
	
	
	public Long getId(){
		return this.id;
	}
	
	public void setId (Long id){
		this.id = id;
	}
	
	
	public String getUser(){
		return this.user;
	}
	
	public void setUser(String user){
		this.user = user;
	}
	
	public String getPasswd(){
		return this.passwd;
	}
	
	public void setPasswd(String passwd){
		this.passwd = passwd;
	}
	
}