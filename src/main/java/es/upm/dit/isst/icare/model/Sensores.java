package es.upm.dit.isst.icare.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Sensores implements Serializable{
	
	private static final long serialVersionUID = 01L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Index
	private Pacientes paciente;
	
	@Index
	private Long idPaciente;
	
	@Index
	private Date fecha;
	
	@Index
	private int pulsometro; //60-100 ppm
	
	@Index
	private double azucar; //70-130
	
	@Index
	private double oxigeno; //90-100%
	
	@Index
	private int tension_sist;//120-140mmhg
	
	@Index
	private int tension_diast; //80-90mmhg
	
	@Index
	private double consumo_agua; //en minutos en la ducha (en comparacion con el valor usual)
	
	@Index
	private double acelerometro; //metros segundo2 7-18
	
	@Index
	private double CO; //nivel monoxido de carbono 0.5-5 ppm
	
	@Index
	private double temperatura;//36.1-37.2ºc
	
	@Index
	private double CO2;//350-5000 ppm
	
	public Sensores (){
		
	}

	public Sensores(Pacientes paciente, Long idPaciente, Date fecha, int pulsometro, double azucar,
			double oxigeno, int tension_sist, int tension_diast, double consumo_agua, double acelerometro, double cO,
			double temperatura, double co2) {
		super();
		this.paciente = paciente;
		this.idPaciente = paciente.getId();
		this.fecha = fecha;
		this.pulsometro = pulsometro;
		this.azucar = azucar;
		this.oxigeno = oxigeno;
		this.tension_sist = tension_sist;
		this.tension_diast = tension_diast;
		this.consumo_agua = consumo_agua;
		this.acelerometro = acelerometro;
		this.CO = cO;
		this.temperatura = temperatura;
		this.CO2 = co2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pacientes getPaciente() {
		return paciente;
	}

	public void setPaciente(Pacientes paciente) {
		this.paciente = paciente;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getPulsometro() {
		return pulsometro;
	}

	public void setPulsometro(int pulsometro) {
		this.pulsometro = pulsometro;
	}

	

	public double getCO2() {
		return CO2;
	}

	public void setCO2(double cO2) {
		CO2 = cO2;
	}

	public double getAzucar() {
		return azucar;
	}

	public void setAzucar(double azucar) {
		this.azucar = azucar;
	}

	public double getOxigeno() {
		return oxigeno;
	}

	public void setOxigeno(double oxigeno) {
		this.oxigeno = oxigeno;
	}

	public int getTension_sist() {
		return tension_sist;
	}

	public void setTension_sist(int tension_sist) {
		this.tension_sist = tension_sist;
	}

	public int getTension_diast() {
		return tension_diast;
	}

	public void setTension_diast(int tension_diast) {
		this.tension_diast = tension_diast;
	}

	public double getConsumo_agua() {
		return consumo_agua;
	}

	public void setConsumo_agua(double consumo_agua) {
		this.consumo_agua = consumo_agua;
	}

	public double getAcelerometro() {
		return acelerometro;
	}

	public void setAcelerometro(double acelerometro) {
		this.acelerometro = acelerometro;
	}

	public double getCO() {
		return CO;
	}

	public void setCO(double cO) {
		CO = cO;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

}
