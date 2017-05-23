package es.upm.dit.isst.icare.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Pacientes implements Serializable {

private static final long serialVersionUID = 01L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Index
	private String nombre;
	@Index
	private String apellidos;
	@Index
	private String dni;
	@Index
	private String NUSS;
	@Index
	private int edad;
	@Index
	private String nacimiento;
	@Index
	private String dir;
	@Index
	private String ciudad;
	@Index
	private int cp;
	@Index
	private String estadocivil;
	@Index
	private String enf;
	@Index
	private String disc;
	@Index
	private String vivesolo;
	@Index
	private String nombrecuid;
	@Index
	private String apellcuid;
	@Index
	private String tlfcuid;
	@Index
	private String nombrefam;
	@Index
	private String apellfam;
	@Index
	private String tlffam;
	
	@Index
	private String paciente;
	@Index
	private String cuidador;
	@Index
	private String familiar;
	
	@Index
	private Date ult_fecha;
	@Index
	private int ult_nivel;
	
	@Index
	private int consumoAguaMedio;

	public Pacientes() {
		
	}


	public Pacientes(String nombre, String apellidos, String dNI, String nUSS, int edad, String nacimiento,
			String dir, String ciudad, int cp, String estadocivil, String enf, String disc, String vivesolo,
			String nombrecuid, String apellcuid, String tlfcuid, String nombrefam, String apellfam, String tlffam, int agua) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dNI;
		this.NUSS = nUSS;
		this.edad = edad;
		this.nacimiento = nacimiento;
		this.dir = dir;
		this.ciudad = ciudad;
		this.cp = cp;
		this.estadocivil = estadocivil;
		this.enf = enf;
		this.disc = disc;
		this.vivesolo = vivesolo;
		this.nombrecuid = nombrecuid;
		this.apellcuid = apellcuid;
		this.tlfcuid = tlfcuid;
		this.nombrefam = nombrefam;
		this.apellfam = apellfam;
		this.tlffam = tlffam;
		
		this.paciente = nombre + " " + apellidos;
		this.cuidador = nombrecuid + " " + apellcuid;
		this.familiar = nombrefam + " " + apellfam;
		
		this.ult_fecha = null;
		this.ult_nivel = 0;
		
		this.consumoAguaMedio = agua;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}

	public Date getUlt_fecha() {
		return ult_fecha;
	}

	public void setUlt_fecha(Date ult_fecha) {
		this.ult_fecha = ult_fecha;
	}

	public int getUlt_nivel() {
		return ult_nivel;
	}

	public void setUlt_nivel(int ult_nivel) {
		this.ult_nivel = ult_nivel;
	}

	public String getPaciente() {
		return this.paciente;
	}




	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	
	public String getCuidador() {
		return this.cuidador;
	}




	public void setCuidador(String cuidador) {
		this.cuidador = cuidador;
	}




	public String getFamiliar() {
		return this.familiar;
	}




	public void setFamiliar(String familiar) {
		this.familiar = familiar;
	}


	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}




	public String getDni() {
		return dni;
	}




	public void setDni(String dni) {
		this.dni = dni;
	}




	public String getNUSS() {
		return NUSS;
	}




	public void setNUSS(String nUSS) {
		NUSS = nUSS;
	}




	public int getEdad() {
		return edad;
	}




	public void setEdad(int edad) {
		this.edad = edad;
	}




	public String getNacimiento() {
		return nacimiento;
	}




	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}




	public String getDir() {
		return dir;
	}




	public void setDir(String dir) {
		this.dir = dir;
	}




	public String getCiudad() {
		return ciudad;
	}




	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}




	public int getCp() {
		return cp;
	}




	public void setCp(int cp) {
		this.cp = cp;
	}




	public String getEstadocivil() {
		return estadocivil;
	}




	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}




	public String getEnf() {
		return enf;
	}




	public void setEnf(String enf) {
		this.enf = enf;
	}




	public String getDisc() {
		return disc;
	}




	public void setDisc(String disc) {
		this.disc = disc;
	}




	public String getVivesolo() {
		return vivesolo;
	}




	public void setVivesolo(String vivesolo) {
		this.vivesolo = vivesolo;
	}




	public String getNombrecuid() {
		return nombrecuid;
	}




	public void setNombrecuid(String nombrecuid) {
		this.nombrecuid = nombrecuid;
	}




	public String getApellcuid() {
		return apellcuid;
	}




	public void setApellcuid(String apellcuid) {
		this.apellcuid = apellcuid;
	}




	public String getTlfcuid() {
		return tlfcuid;
	}




	public void setTlfcuid(String tlfcuid) {
		this.tlfcuid = tlfcuid;
	}




	public String getNombrefam() {
		return nombrefam;
	}




	public void setNombrefam(String nombrefam) {
		this.nombrefam = nombrefam;
	}




	public String getApellfam() {
		return apellfam;
	}




	public void setApellfam(String apellfam) {
		this.apellfam = apellfam;
	}




	public String getTlffam() {
		return tlffam;
	}




	public void setTlffam(String tlffam) {
		this.tlffam = tlffam;
	}




	public int getConsumoAguaMedio() {
		return consumoAguaMedio;
	}




	public void setConsumoAguaMedio(int consumoAguaMedio) {
		this.consumoAguaMedio = consumoAguaMedio;
	}
	
	
}