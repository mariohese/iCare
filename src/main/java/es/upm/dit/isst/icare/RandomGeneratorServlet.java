package es.upm.dit.isst.icare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.AlarmsDAO;
import es.upm.dit.isst.icare.dao.AlarmsDAOImpl;
import es.upm.dit.isst.icare.dao.AnomaliasDAO;
import es.upm.dit.isst.icare.dao.AnomaliasDAOImpl;
import es.upm.dit.isst.icare.dao.LoginDAO;
import es.upm.dit.isst.icare.dao.LoginDAOImpl;
import es.upm.dit.isst.icare.dao.PacientesDAOImpl;
import es.upm.dit.isst.icare.dao.RecursosDAO;
import es.upm.dit.isst.icare.dao.RecursosDAOImpl;
import es.upm.dit.isst.icare.dao.SensoresDAO;
import es.upm.dit.isst.icare.dao.SensoresDAOImpl;
import es.upm.dit.isst.icare.model.Alarms;
import es.upm.dit.isst.icare.model.Anomalias;
import es.upm.dit.isst.icare.model.Login;
import es.upm.dit.isst.icare.model.Pacientes;
import es.upm.dit.isst.icare.model.Recursos;
import es.upm.dit.isst.icare.model.Sensores;

public class RandomGeneratorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		
		RequestDispatcher view = req.getRequestDispatcher("random_events.jsp");
		view.forward(req, resp);
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		//se ha pulsado alarma
		boolean pulsado = false;
		
		//numero aleatorio
		Random aleatorio = new Random(System.currentTimeMillis());
		
		//botones
		String escenario1 = checkNull(req.getParameter("sos"));
		String escenario2 = checkNull(req.getParameter("esc2"));
		String escenario3 = checkNull(req.getParameter("esc3"));
		String escenario4 = checkNull(req.getParameter("esc4"));
		String inicio_rec = checkNull(req.getParameter("inicio"));
		
		//Inicializacion de DAOs
		AnomaliasDAO daoAn = AnomaliasDAOImpl.getInstance();
		AlarmsDAO daoAl = AlarmsDAOImpl.getInstancia();
		SensoresDAO daoSens = SensoresDAOImpl.getInstancia();
		RecursosDAO daoRec = RecursosDAOImpl.getInstancia();
		
		
		//pacientes registrados en la aplicación
		List <Pacientes> pacientes = (PacientesDAOImpl.getInstance()).listPacientes();
		
		//lista de datos sensores no anomalos, uno para cada paciente, del tiron
		int [] pulso = {62, 68, 70, 71, 78, 80, 83, 86, 88, 91, 92, 94, 95, 99};
		double [] azucar = {71.2, 72.1, 73.8, 75.9, 78.9, 82.1, 84.6, 87.9, 91.2, 95.6, 99.2, 101.3, 111.1, 113.4, 118.9, 120.7, 1123.5, 126.7, 129.8};
		double [] oxig = {90.2, 91.1, 91.8, 92.1, 92.3, 93.4, 93.9, 94.5, 95.0, 95.3, 95.8, 96.7, 97.9,98.1, 99.2, 99.9};
		int [] sist = {121, 122, 123, 124, 126, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140};
		int [] diast = {80,81,82,83,84,85,86,87,89,90};
		double [] acelerometro = {7.1, 7.4, 7.9, 8.2, 8.5, 8.8, 9.1, 9.6, 9.7, 10.6, 10.9, 11.1, 11.5, 11.9, 12.7, 13.6, 14.7, 15.1, 15.8, 16.3, 16.8, 17.3, 17.7, 17.9};
		double [] CO = {0.5, 0.78, 0.99, 1.2, 1.62, 1.89, 2.32, 2.67, 2.78, 3.56,3.87, 4.11, 4.43, 4.59, 4.87, 4.89};
		double [] temp = {36.1, 36.3, 36.5, 36.7, 36.9, 37.1, 37.2};
		double [] CO2 = {350, 380, 400, 420, 440, 480, 510, 550, 600, 670, 720, 780, 810, 880, 1100, 1200, 1700, 2200, 2400, 2689, 3239, 3678, 3890, 4123, 4387, 4478, 4897, 5000};
		int [] desviacion_agua = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
		//indices al azar de cada array
		int aleatPulso = aleatorio.nextInt(pulso.length);
		int aleatAz = aleatorio.nextInt(azucar.length);
		int aleatOx = aleatorio.nextInt(oxig.length);
		int aleatSist = aleatorio.nextInt(sist.length);
		int aleatDiast = aleatorio.nextInt(diast.length);
		int aleatAc = aleatorio.nextInt(acelerometro.length);
		int aleatCO = aleatorio.nextInt(CO.length);
		int aleatTemp = aleatorio.nextInt(temp.length);
		int aleatCO2 = aleatorio.nextInt(CO2.length);
		int aleatAgua = aleatorio.nextInt(desviacion_agua.length);
		//valor elegido de cada array de sensores
		int p = pulso [aleatPulso];
		double az = azucar [aleatAz];
		double ox = oxig [aleatOx];
		int sis = sist [aleatSist];
		int dias = diast [aleatDiast];
		int ag = desviacion_agua[aleatAgua];
		double ac = acelerometro [aleatAc];
		double co = CO [aleatCO];
		double t = temp [aleatTemp];
		double co2 = CO2 [aleatCO2];

		//Generamos posibles localizaciones de la alarma
		String [] locAlarm = {"Paseo de la Independencia, 17", "Calle Espinosa y Cárcel, 27", "Carrer de Ramón Perellós, 7", "Carrer del Remei, 30", "Calle de los Narcisos, 13"};
		double [] latitudAl = {41.65122, 37.378314, 39.455499, 41.386050, 40.453545};
		double [] longAl = {-0.881962, -5.974182, -0.391847, 2.130401, -3.666525};
		
		
		
		
		//ESCENARIO 2:
		//dos pacientes, uno alarma y otro anomalia a partir de sensores
		if (escenario2.equals("esc2")){
			
			//Generacion al azar de la localizacion de la alarma
			
			//mismo indice para las tres porque esta en orden
			int aleatLocAl = aleatorio.nextInt(locAlarm.length);
			String locAl = locAlarm[aleatLocAl];
			double latAlarm = latitudAl[aleatLocAl];
			double longAlarm = longAl[aleatLocAl];
			
			//Recursos asociados a la ubicacion de la alarma
			List <Recursos> recursos = daoRec.readAlarmResource(locAl);
			int num_rec = recursos.size();
			String [] locRec = new String [recursos.size()];
			double [] latRec = new double [recursos.size()];
			double [] longRec = new double [recursos.size()];
			String [] tipoRec = new String [recursos.size()];
			int [] tlfRec = new int [recursos.size()];
			for (int i = 0; i < recursos.size(); i++){
				locRec[i] = recursos.get(i).getLocRecurso();
				latRec[i] = recursos.get(i).getLatitud();
				longRec[i] = recursos.get(i).getAltitud();
				tlfRec[i] = recursos.get(i).getTelf();
				tipoRec[i] = recursos.get(i).getTipo();
			}
			
			for (int i = 0; i < recursos.size(); i++){
				req.getSession().setAttribute("local"+i, locRec[i]);
				req.getSession().setAttribute("latitudes"+i, latRec[i]);
				req.getSession().setAttribute("longs"+i, longRec[i]);
				req.getSession().setAttribute("tlf"+i, tlfRec[i]);
				req.getSession().setAttribute("tipo"+i, tipoRec[i]);
			}
			
			
			//Seleccionamos dos pacientes al azar
			int aleatPac1 = aleatorio.nextInt(pacientes.size());
			int aleatPac2 = aleatorio.nextInt(pacientes.size());
			
			System.out.println(aleatPac1);
			System.out.println(aleatPac2);
			
			Pacientes pac1 = pacientes.get(aleatPac1);
			Pacientes pac2 = pacientes.get(aleatPac2);
			Date fecha1 = new Date();
			Date fecha2 = new Date();
			fecha2.setHours(fecha2.getHours() - 1);
			
			//Generacion de anomalias PACIENTE 1
			Sensores azucar_bajo = new Sensores(pac1, pac1.getId(), fecha2, p, 45, ox, sis, dias, pac1.getConsumoAguaMedio() + ag, ac, co, t, co2);
			Sensores puls_bajas = new Sensores(pac1, pac1.getId(), fecha2, 36, az, ox, sis, dias, pac1.getConsumoAguaMedio() + ag, ac, co, t, co2);
			Sensores elevado_CO = new Sensores(pac1, pac1.getId(), fecha2, p, az, ox, sis, dias, pac1.getConsumoAguaMedio() + ag, ac, 11, t, co2);
			Sensores azucar_alto = new Sensores(pac1, pac1.getId(), fecha2, p, 150, ox, sis, dias, pac1.getConsumoAguaMedio() + ag, ac, co, t, co2);
			Anomalias az_baj = new Anomalias(pac1, "Nivel azúcar bajo: 45 mg/dl", fecha2);
			Anomalias puls_baj = new Anomalias(pac1, "Pulsaciones bajas: 36", fecha2);
			Anomalias el_CO = new Anomalias(pac1, "Elevado nivel de Monóxido de Carbono (CO): 11 ppm", fecha2);
			Anomalias az_alto = new Anomalias(pac1, "Nivel azúcar elevado: 150 mg/dl", fecha2);
			//Anomalias asociadas a los sensores anomalos
			Anomalias [] anomalias = {az_baj, puls_baj, el_CO, az_alto};
			Sensores [] an_sens = {azucar_bajo, puls_bajas, elevado_CO, azucar_alto};
			
			//Eventos de alarma a partir de suma de datos anomalos PACIENTE 2
			Sensores desmayo_al = new Sensores(pac2, pac2.getId(), fecha1, p, 50, ox, sis, 60, pac2.getConsumoAguaMedio() + ag, 25, co, t, co2);
			Sensores incendio_al = new Sensores(pac2, pac2.getId(), fecha1, p, az, ox, sis, dias, pac2.getConsumoAguaMedio() + ag, ac, co, 615, 52500);
			//Sensores resbalon_al = new Sensores(pac2, pac2.getId(), fecha1, p, az, ox, sis, dias, pac2.getConsumoAguaMedio() + 30, 31, co, t, co2);
			Alarms desmayo = new Alarms(pac2, "Desmayo", "Sin atender", "-", 9, "-", fecha1, locAl, latAlarm, longAlarm);
			Alarms incendio = new Alarms(pac2, "Incendio", "Sin atender", "-", 10, "-", fecha1, locAl, latAlarm, longAlarm);
			
			Anomalias desmayo_an1 = new Anomalias(pac2, "Azúcar bajo: 50 mg/dl", fecha1);
			Anomalias desmayo_an2= new Anomalias(pac2, "Tensión baja: 60", fecha1);
			Anomalias desmayo_an3 = new Anomalias(pac2, "Acelerómetro: 25 m/s2", fecha1);
			
			Anomalias incendio_an1 = new Anomalias(pac2, "Temperatura: 615 ºC", fecha1);
			Anomalias incencio_an2= new Anomalias(pac2, "Nivel CO2 elevado: 52500 ppm", fecha1);
			//Alarms resbalon = new Alarms(pac2, "Caída por resbalón", "Sin atender", "-", 8, "-", fecha1, locAl, latAlarm, longAlarm);
			//Alarmas asociadas a los sensores anomalos
			Alarms [] alarmas = {desmayo, incendio};
			Sensores [] als = {desmayo_al, incendio_al};
			
			//Eleccion de alarma y anomalia al azar con sus datos de sensores asociados
			int aleatAnomalia = aleatorio.nextInt(an_sens.length);
			int aleatAlarma = aleatorio.nextInt(alarmas.length);
			Sensores an_s = an_sens[aleatAnomalia];
			Anomalias an_an = anomalias[aleatAnomalia];
			Sensores al_s = als[aleatAlarma];
			Alarms al_al = alarmas[aleatAlarma];
		
			//comprobar si la alarma esta en casa del paciente, y añadir su telf y contacto
			String loc = al_al.getLocalizacion();
			String lugar_al = "";
			
			if (loc.equals(pac2.getDir())){
				lugar_al = " en domicilio: ";
			} else{
				lugar_al = " fuera del domicilio: ";
			}
			lugar_al = "ALARMA" + lugar_al+ al_al.getLocalizacion();
			
			//Parametros de la alarma
			req.getSession().setAttribute("al_loc", lugar_al);
			req.getSession().setAttribute("al_lat", al_al.getLatitud());
			req.getSession().setAttribute("al_long", al_al.getLongitud());
			req.getSession().setAttribute("al_tlf", pac2.getTlfcuid());
			
			pulsado = true;
			req.getSession().setAttribute("nrec", num_rec);
			req.getSession().setAttribute("urgencia", pulsado);
			req.getSession().setAttribute("alarma", al_al);
			
			daoSens.create(al_s);
			daoSens.create(an_s);
			daoAl.create(al_al);
			daoAn.create(an_an);
			if (aleatAlarma == 0){
				daoAn.create(desmayo_an1);
				daoAn.create(desmayo_an2);
				daoAn.create(desmayo_an3);
			}else if(aleatAlarma == 1){
				daoAn.create(incendio_an1);
				daoAn.create(incencio_an2);
			}
			
		}
		
		
		//ESCENARIO 3:
		//generar datos sensores dentro de limites a la vez para todos los pacientes
		else if(escenario3.equals("esc3")){
			
			for(int i= 0; i < pacientes.size(); i++){
				
				daoSens.create(pacientes.get(i), pacientes.get(i).getId(), new Date(), p, az, ox, sis, dias, pacientes.get(i).getConsumoAguaMedio() + ag, ac, co, t, co2);
				
			}
			
		}
		//ESCENARIO 4:
		//Tres anomalias seguidas que generan alarma
		else if(escenario4.equals("esc4")){
			
//Generacion al azar de la localizacion de la alarma
			
			//mismo indice para las tres porque esta en orden
			int aleatLocAl = aleatorio.nextInt(locAlarm.length);
			String locAl = locAlarm[aleatLocAl];
			double latAlarm = latitudAl[aleatLocAl];
			double longAlarm = longAl[aleatLocAl];
			
			//Recursos asociados a la ubicacion de la alarma
			List <Recursos> recursos = daoRec.readAlarmResource(locAl);
			int num_rec = recursos.size();
			String [] locRec = new String [recursos.size()];
			double [] latRec = new double [recursos.size()];
			double [] longRec = new double [recursos.size()];
			String [] tipoRec = new String [recursos.size()];
			int [] tlfRec = new int [recursos.size()];
			for (int i = 0; i < recursos.size(); i++){
				locRec[i] = recursos.get(i).getLocRecurso();
				latRec[i] = recursos.get(i).getLatitud();
				longRec[i] = recursos.get(i).getAltitud();
				tlfRec[i] = recursos.get(i).getTelf();
				tipoRec[i] = recursos.get(i).getTipo();
			}
			
			for (int i = 0; i < recursos.size(); i++){
				req.getSession().setAttribute("local"+i, locRec[i]);
				req.getSession().setAttribute("latitudes"+i, latRec[i]);
				req.getSession().setAttribute("longs"+i, longRec[i]);
				req.getSession().setAttribute("tlf"+i, tlfRec[i]);
				req.getSession().setAttribute("tipo"+i, tipoRec[i]);
			}
			
			//Generacion de 3 fechas en diferencia de 2 minutos
			Date fecha1 = new Date();
			Date fecha2 = new Date();
			Date fecha3 = new Date();
			fecha2.setMinutes(fecha1.getMinutes() - 1);
			fecha3.setMinutes(fecha1.getMinutes() - 2);
			
			
			//Seleccionamos dos pacientes al azar
			int aleatPac1 = aleatorio.nextInt(pacientes.size());
			Pacientes pac = pacientes.get(aleatPac1);
			
			Sensores puls_bajas1 = new Sensores(pac, pac.getId(), fecha1, 36, az, ox, sis, dias, pac.getConsumoAguaMedio() + ag, ac, co, t, co2);
			Sensores puls_bajas2 = new Sensores(pac, pac.getId(), fecha2, 31, az, ox, sis, dias, pac.getConsumoAguaMedio() + ag, ac, co, t, co2);
			Sensores puls_bajas3 = new Sensores(pac, pac.getId(), fecha3, 28, az, ox, sis, dias, pac.getConsumoAguaMedio() + ag, ac, co, t, co2);

			Anomalias an1 = new Anomalias(pac, "Pulsaciones bajas: 36 por minuto", fecha1);
			Anomalias an2 = new Anomalias(pac, "Pulsaciones bajas: 31 por minuto", fecha2);
			Anomalias an3 = new Anomalias(pac, "Pulsaciones bajas: 28 por minuto", fecha3);
			
			Alarms al_al = new Alarms (pac, "Pulsaciones/minuto bajando (3 tomas)", "Sin atender", "-",7, "-", fecha1, locAl, latAlarm, longAlarm);
		
			//comprobar si la alarma esta en casa del paciente, y añadir su telf y contacto
			String loc = al_al.getLocalizacion();
			String lugar_al = "";
			
			if (loc.equals(pac.getDir())){
				lugar_al = " en domicilio: ";
			} else{
				lugar_al = " fuera del domicilio: ";
			}
			lugar_al = "ALARMA" + lugar_al+ al_al.getLocalizacion();
			
			//Parametros de la alarma
			req.getSession().setAttribute("al_loc", lugar_al);
			req.getSession().setAttribute("al_lat", al_al.getLatitud());
			req.getSession().setAttribute("al_long", al_al.getLongitud());
			req.getSession().setAttribute("al_tlf", pac.getTlfcuid());
			
			pulsado = true;
			req.getSession().setAttribute("nrec", num_rec);
			req.getSession().setAttribute("urgencia", pulsado);
			req.getSession().setAttribute("alarma", al_al);
			
			daoAl.create(al_al);
			daoSens.create(puls_bajas1);
			daoSens.create(puls_bajas2);
			daoSens.create(puls_bajas3);
			daoAn.create(an1);
			daoAn.create(an2);
			daoAn.create(an3);
			
		}
		
		//ESCENARIO 1:
		//Alarma de BOTON DE PANICO
		else if (escenario1.equals("sos")){
			
			
			int aleatPac1 = aleatorio.nextInt(pacientes.size());
			Pacientes pac = pacientes.get(aleatPac1);
			
			//mismo indice para las tres porque esta en orden
			int aleatLocAl = aleatorio.nextInt(locAlarm.length);
			String locAl = locAlarm[aleatLocAl];
			double latAlarm = latitudAl[aleatLocAl];
			double longAlarm = longAl[aleatLocAl];
			
			Alarms alarma = daoAl.create(pac, "BOTÓN SOS PULSADO", "Sin atender", "-", 10, "-", new Date(),locAl, latAlarm, longAlarm);
			
			//Recursos asociados a la ubicacion de la alarma
			List <Recursos> recursos = daoRec.readAlarmResource(locAl);
			int num_rec = recursos.size();
			String [] locRec = new String [recursos.size()];
			double [] latRec = new double [recursos.size()];
			double [] longRec = new double [recursos.size()];
			String [] tipoRec = new String [recursos.size()];
			int [] tlfRec = new int [recursos.size()];
			for (int i = 0; i < recursos.size(); i++){
				locRec[i] = recursos.get(i).getLocRecurso();
				latRec[i] = recursos.get(i).getLatitud();
				longRec[i] = recursos.get(i).getAltitud();
				tlfRec[i] = recursos.get(i).getTelf();
				tipoRec[i] = recursos.get(i).getTipo();
			}
			
			
			pulsado = true;
			
			for (int i = 0; i < recursos.size(); i++){
				req.getSession().setAttribute("local"+i, locRec[i]);
				req.getSession().setAttribute("latitudes"+i, latRec[i]);
				req.getSession().setAttribute("longs"+i, longRec[i]);
				req.getSession().setAttribute("tlf"+i, tlfRec[i]);
				req.getSession().setAttribute("tipo"+i, tipoRec[i]);
			}
			
			req.getSession().setAttribute("nrec", num_rec);
			req.getSession().setAttribute("urgencia", pulsado);
			req.getSession().setAttribute("alarma", alarma);
			
			//comprobar si la alarma esta en casa del paciente, y añadir su telf y contacto
			String loc = alarma.getLocalizacion();
			String lugar_al = "";
			
			if (loc.equals(pac.getDir())){
				lugar_al = " en domicilio: ";
			} else{
				lugar_al = " fuera del domicilio: ";
			}
			lugar_al = "ALARMA" + lugar_al+ alarma.getLocalizacion();
			
			req.getSession().setAttribute("al_loc", lugar_al);
			req.getSession().setAttribute("al_lat", alarma.getLatitud());
			req.getSession().setAttribute("al_long", alarma.getLongitud());
			req.getSession().setAttribute("al_tlf", pac.getTlfcuid());
		}
		
		
		
		
		
		
		// INICIALIZAR ESCENARIO CON LOS RECURSOS
		else if (inicio_rec.equals("inicio")){
			//FORMATO: alarma generada en, recurso cercano, latitud, longitud, tipo recurso
			
			//ALARMA 2: Zaragoza
			daoRec.create("Paseo de la Independencia, 17", "Clínica Hernán Cortés",41.649107,-0.888143,976222981, "Hospital");
			daoRec.create("Paseo de la Independencia, 17", "Hospital Provincial Nuestra Señora de Gracia",41.652414,-0.887680,976440022, "Hospital");

			daoRec.create("Paseo de la Independencia, 17", "Parque de bomberos 2 de Zaragoza",41.653816,-0.886350,976723790, "Bomberos");
			daoRec.create("Paseo de la Independencia, 17", "Parque de bomberos 3 de Zaragoza",41.638577,-0.900010,976724168, "Bomberos");

			daoRec.create("Paseo de la Independencia, 17", "Centro Municipal de Servicios Sociales Delicias",41.648514,-0.908336,976726010, "Sociales");
			daoRec.create("Paseo de la Independencia, 17", "Instituto Aragonés de Servicios Sociales de Zaragoza",41.642773,-0.879411,976716220, "Sociales");
		
			//ALARMA 3: Sevilla
			daoRec.create("Calle Espinosa y Cárcel, 27", "Hospital San Juan de Dios",37.381656,-5.969139,954939300, "Hospital");
			daoRec.create("Calle Espinosa y Cárcel, 27", "Hospital Fátima",37.368865,-5.988129,955040363, "Hospital");

			daoRec.create("Calle Espinosa y Cárcel, 27", "Parque Central de Bomberos de Sevilla nº2",37.388256,-5.984684,955473377, "Bomberos");
			daoRec.create("Calle Espinosa y Cárcel, 27", "Parque de Bomberos nº5",37.364237,-5.960308,955840360, "Bomberos");

			daoRec.create("Calle Espinosa y Cárcel, 27", "Servicio Andaluz de Teleasistencia",37.397499, -5.971123,900200165, "Sociales");
			daoRec.create("Calle Espinosa y Cárcel, 27", "Centro de Servicios Sociales Polígono Sur",37.369211, -5.964889,955473460, "Sociales");
		
			//ALARMA 4: Valencia
			daoRec.create("Carrer de Ramón Perellós, 7", "Hospital Padre Jofre",39.453660, -0.393950,961223900, "Hospital");
			daoRec.create("Carrer de Ramón Perellós, 7", "Hospital Universitario Doctor Peset",39.452691, -0.393714,961622300, "Hospital");

			daoRec.create("Carrer de Ramón Perellós, 7", "Parque Central de Bomberos",39.457763, -0.368304,961754148, "Bomberos");
			daoRec.create("Carrer de Ramón Perellós, 7", "Parque De Bomberos Campanar",39.486650, -0.406757,961847235, "Bomberos");

			daoRec.create("Carrer de Ramón Perellós, 7", "Centro Municipal de Servicios Sociales Sant Marcel·lí",39.443437, -0.389848,962741864, "Sociales");
			daoRec.create("Carrer de Ramón Perellós, 7", "Centro Municipal de Servicios Sociales Fuensanta",39.467756, -0.407872,962084670, "Sociales");
		
			//ALARMA 5: BCN
			daoRec.create("Carrer del Remei, 30", "Hospital Clínico Barcelona", 41.386170, 2.135470,932275400, "Hospital");
			daoRec.create("Carrer del Remei, 30", "Barnaclinic", 41.385261, 2.126329,932279391, "Hospital");

			daoRec.create("Carrer del Remei, 30", "Parc de Bombers de l'Eixample", 41.378497, 2.146950,932915353, "Bomberos");
			daoRec.create("Carrer del Remei, 30", "Espai Bombers",41.373600, 2.153988 ,932565434, "Bomberos");

			daoRec.create("Carrer del Remei, 30", "Centre de Serveis Socials Cotxeres de Sants",41.375429, 2.136697 ,936197311, "Sociales");
			daoRec.create("Carrer del Remei, 30", "Serveis Territorials de Benestar Social I Familia A Barcelona",41.378391, 2.144937 ,935675160, "Sociales");
			
			//ALARMA 6: MADRID
			daoRec.create("Calle de los Narcisos, 13", "Hospital San Rafael",40.452213, -3.681705,915649944, "Hospital");
			daoRec.create("Calle de los Narcisos, 13", "Hospital Virgen del Mar",40.459294, -3.678789,913539500, "Hospital");

			daoRec.create("Calle de los Narcisos, 13", "Parque de Bomberos Chamberí",40.440098, -3.700805,913952335, "Bomberos");
			daoRec.create("Calle de los Narcisos, 13", "Parque de Bomberos 4 Tetuán",40.470924, -3.696084,913238444, "Bomberos");

			daoRec.create("Calle de los Narcisos, 13", "Servicios Sociales Santa Hortensia",40.445060, -3.668704,915106850, "Sociales");
			daoRec.create("Calle de los Narcisos, 13", "Centro Servicios Sociales María Zayas",40.459298, -3.701749,914492140, "Sociales");
			
		}
		else {
			
		}
		
		req.getSession().setAttribute("pulsado", pulsado);
		resp.sendRedirect("/generator");
	}
	
	private String checkNull(String s) {
		if (s== null){
			return "";
		}
		return s;
	}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Anomalias.class);
		ObjectifyService.register(Pacientes.class);
		ObjectifyService.register(Alarms.class);
		ObjectifyService.register(Login.class);
		ObjectifyService.register(Recursos.class);
		ObjectifyService.register(Sensores.class);
	}
}
