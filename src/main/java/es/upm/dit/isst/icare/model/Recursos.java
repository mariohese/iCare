package es.upm.dit.isst.icare.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Recursos implements Serializable{
	
	private static final long serialVersionUID = 01L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Index
	private String locAlarma;
	
	@Index
	private String locRecurso;
	
	@Index
	private double latitud;
	
	@Index
	private double altitud;
	
	@Index
	private int telf;
	
	@Index
	private String tipo;
	
	public Recursos(){
		
	}

	public Recursos(String locAlarma, String locRecurso, double latitud, double altitud, int telf, String tipo) {
		super();
		this.locAlarma = locAlarma;
		this.locRecurso = locRecurso;
		this.latitud = latitud;
		this.altitud = altitud;
		this.telf = telf;
		this.tipo = tipo;
	}

	public String getLocAlarma() {
		return locAlarma;
	}

	public void setLocAlarma(String locAlarma) {
		this.locAlarma = locAlarma;
	}

	
	
	public int getTelf() {
		return telf;
	}

	public void setTelf(int telf) {
		this.telf = telf;
	}

	public String getLocRecurso() {
		return locRecurso;
	}

	public void setLocRecurso(String locRecurso) {
		this.locRecurso = locRecurso;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getAltitud() {
		return altitud;
	}

	public void setAltitud(double altitud) {
		this.altitud = altitud;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
