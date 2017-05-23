package es.upm.dit.isst.icare;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.AlarmsDAO;
import es.upm.dit.isst.icare.dao.AlarmsDAOImpl;
import es.upm.dit.isst.icare.model.Alarms;
import es.upm.dit.isst.icare.model.Pacientes;

public class SaveAlarmServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
		String parametros = req.getQueryString();
		System.out.println(parametros);
		
		String [] div = parametros.split("&");
		String [] div_id = div[0].split("=");
		String [] div_dec = div[1].split("=");
		
		//id de alarma y decision tomada por el operador y operador
		String idAl = div_id[1];
		String decision = div_dec[1];
		String decision_final = "";
		System.out.println(idAl);
		System.out.println(decision);
		
		if(decision.equals("1")){
			decision_final = "Llamar paciente";
		} else if(decision.equals("2")){
			decision_final = "Llamar contacto paciente";
		}else if (decision.equals("3")){
			decision_final = "Llamar emergencias";
		}else if (decision.equals("4")){
			decision_final = "Iniciar chat";
		}else if (decision.equals("5")){
			decision_final = "Llamar bomberos";
		}else if (decision.equals("6")){
			decision_final = "Llamar personal sociosanitario";
		}
		
		//actualizamos las alarmas en funcion de la decision tomada
		AlarmsDAO daoAl = AlarmsDAOImpl.getInstancia();
		Alarms alarma = daoAl.readAlarmById(idAl);
		alarma.setEstado("Atendida");
		alarma.setDecision(decision_final);
		
		daoAl.update(alarma);
		
		resp.sendRedirect("/main");
	}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Pacientes.class);
		ObjectifyService.register(Alarms.class);
	}

}
