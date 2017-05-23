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
import es.upm.dit.isst.icare.dao.PacientesDAO;
import es.upm.dit.isst.icare.dao.PacientesDAOImpl;
import es.upm.dit.isst.icare.model.Alarms;
import es.upm.dit.isst.icare.model.Pacientes;

public class PatientsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
		PacientesDAO dao = PacientesDAOImpl.getInstance();
		AlarmsDAO daoAl = AlarmsDAOImpl.getInstancia();
		
		List <Pacientes> pacientes = dao.listPacientes();
		List <Alarms> alarmPac = new ArrayList<Alarms>();
		for (int i = 0; i < pacientes.size(); i++){
			String idpac = String.valueOf(pacientes.get(i).getId());
			alarmPac = daoAl.readPacientAlarms(idpac);
			if (alarmPac.size() > 0){
				Collections.sort(alarmPac, new Comparator<Alarms>() {
					  public int compare(Alarms o1, Alarms o2) {
					      return o1.getFecha().compareTo(o2.getFecha());
					  }
				});
				pacientes.get(i).setUlt_fecha(alarmPac.get(alarmPac.size() - 1).getFecha());
				pacientes.get(i).setUlt_nivel(alarmPac.get(alarmPac.size() - 1).getNivel());
			}
		}
		
		req.getSession().setAttribute("pacientes", pacientes);

		
		RequestDispatcher view = req.getRequestDispatcher("patients_list.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Pacientes.class);
		ObjectifyService.register(Alarms.class);
	}

}