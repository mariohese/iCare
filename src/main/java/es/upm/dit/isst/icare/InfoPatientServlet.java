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


public class InfoPatientServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
		//id del paciente seleccionado
		String idStr = req.getParameter("id");
		
		AlarmsDAO daoAlr = AlarmsDAOImpl.getInstancia();
		PacientesDAO dao = PacientesDAOImpl.getInstance();
		AnomaliasDAO daoAn = AnomaliasDAOImpl.getInstance();
		SensoresDAO daoSen = SensoresDAOImpl.getInstancia();
		
		Pacientes paciente = dao.readId(idStr);
		
		List <Sensores> sensores = daoSen.readPacientSensores(idStr);
		List <Anomalias> ans = daoAn.readPacientAnomalies(idStr);
		List <Alarms> alarms = daoAlr.readPacientAlarms(idStr);
		
		
		//alarmas, sensores y anomalias ordenadas
		List <Anomalias> ans_ord = new ArrayList<Anomalias>();
		List <Alarms> alarms_ord = new ArrayList<Alarms>();
		List <Sensores> sens_ord = new ArrayList<Sensores>();
		
		//ordenamos anomalias de menor a mayor
		Collections.sort(ans, new Comparator<Anomalias>() {
			  public int compare(Anomalias o1, Anomalias o2) {
			      return o1.getFecha().compareTo(o2.getFecha());
			  }
		});
		
		//de mayor a menor
		for (int i = ans.size() - 1; i >= 0; i--){
			ans_ord.add(ans.get(i));
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
		
		
		req.getSession().setAttribute("sensores", sens_ord);
		req.getSession().setAttribute("anomalias", ans_ord);
		req.getSession().setAttribute("paciente", paciente);
		req.getSession().setAttribute("alarms", alarms_ord);
		
		RequestDispatcher view = req.getRequestDispatcher("patient_info.jsp");
		view.forward(req, resp);
		
	}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Pacientes.class);
		ObjectifyService.register(Anomalias.class);
		ObjectifyService.register(Sensores.class);
		ObjectifyService.register(Alarms.class);
	}

}