package es.upm.dit.isst.icare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
import es.upm.dit.isst.icare.dao.PacientesDAO;
import es.upm.dit.isst.icare.dao.PacientesDAOImpl;
import es.upm.dit.isst.icare.dao.SensoresDAO;
import es.upm.dit.isst.icare.dao.SensoresDAOImpl;
import es.upm.dit.isst.icare.model.Alarms;
import es.upm.dit.isst.icare.model.Anomalias;
import es.upm.dit.isst.icare.model.Pacientes;
import es.upm.dit.isst.icare.model.Sensores;

public class AlarmContactManagServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
		String info = checkNull(req.getParameter("info"));
		String alan = checkNull(req.getParameter("alan"));
		String cont = checkNull(req.getParameter("cont"));
		String sens = checkNull(req.getParameter("sens"));

		
		//DAOs de cada BBDD
		PacientesDAO daoPac = PacientesDAOImpl.getInstance();
		AlarmsDAO daoAl = AlarmsDAOImpl.getInstancia();
		AnomaliasDAO daoAn = AnomaliasDAOImpl.getInstance();
		SensoresDAO daoSens = SensoresDAOImpl.getInstancia();
		
		//id del paciente y paciente asociado
		String idStr = req.getParameter("id");
		Pacientes paciente = daoPac.readId(idStr);
		
		//Alarmas, anoalias y sensores asociados al paciente
		List <Alarms> alarms = daoAl.readPacientAlarms(idStr);
		List <Anomalias> anomalias = daoAn.readPacientAnomalies(idStr);
		List <Sensores> sensores = daoSens.readPacientSensores(idStr);
		
		//Array de alarmas, anomalias y sensores ordenados
		List <Anomalias> ans_ord = new ArrayList<Anomalias>();
		List <Alarms> alarms_ord = new ArrayList<Alarms>();
		List <Sensores> sens_ord = new ArrayList<Sensores>();
		
		//ordenamos alarmas de menor a mayor
		Collections.sort(anomalias, new Comparator<Anomalias>() {
			  public int compare(Anomalias o1, Anomalias o2) {
			      return o1.getFecha().compareTo(o2.getFecha());
			  }
		});
		
		//de mayor a menor
		for (int i = anomalias.size() - 1; i >= 0; i--){
			ans_ord.add(anomalias.get(i));
		}
		
		//ordenamos alarmas de menor a mayor
		Collections.sort(alarms, new Comparator<Alarms>() {
			  public int compare(Alarms o1, Alarms o2) {
			      return o1.getFecha().compareTo(o2.getFecha());
			  }
		});
		
		//de mayor a menor
		for (int i = alarms.size() - 1; i >= 0; i--){
			alarms_ord.add(alarms.get(i));
		}
		
		//ordenamos sensores de menor a mayor
		Collections.sort(sensores, new Comparator<Sensores>() {
			  public int compare(Sensores o1, Sensores o2) {
			      return o1.getFecha().compareTo(o2.getFecha());
			  }
		});
		
		//de mayor a menor
		for (int i = sensores.size() - 1; i >= 0; i--){
			sens_ord.add(sensores.get(i));
		}
		
		
		if (info.equals("info")){
			System.out.println("Entra en info");
			req.getSession().setAttribute("info", true);
			req.getSession().setAttribute("alan", false);
			req.getSession().setAttribute("cont", false);
			req.getSession().setAttribute("sens", false);
			req.getSession().setAttribute("paciente", paciente);
			RequestDispatcher view = req.getRequestDispatcher("alarm_manag.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (alan.equals("alan")){
			System.out.println("Entra en alan");
			req.getSession().setAttribute("alan", true);
			req.getSession().setAttribute("info", false);
			req.getSession().setAttribute("cont", false);
			req.getSession().setAttribute("sens", false);
			req.getSession().setAttribute("alarms", alarms_ord);
			req.getSession().setAttribute("anomalias", ans_ord);
			
			RequestDispatcher view = req.getRequestDispatcher("alarm_manag.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (sens.equals("sens")){
			System.out.println("Entra en sens");
			req.getSession().setAttribute("sens", true);
			req.getSession().setAttribute("info", false);
			req.getSession().setAttribute("alan", false);
			req.getSession().setAttribute("cont", false);
			req.getSession().setAttribute("sensores", sens_ord);
			RequestDispatcher view = req.getRequestDispatcher("alarm_manag.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (cont.equals("cont")){
			System.out.println("Entra en cont");

			req.getSession().setAttribute("cont", true);
			req.getSession().setAttribute("info", false);
			req.getSession().setAttribute("alan", false);
			req.getSession().setAttribute("sens", false);
			req.getSession().setAttribute("paciente", paciente);
			
			
			RequestDispatcher view = req.getRequestDispatcher("alarm_manag.jsp");
			try {

				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
	
		
		}
		
		
	}

	
	private String checkNull(String s) {
		if (s== null){
			return "";
		}
		return s;
	}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Pacientes.class);
		ObjectifyService.register(Alarms.class);
		ObjectifyService.register(Sensores.class);
		ObjectifyService.register(Anomalias.class);
	}
	
}
