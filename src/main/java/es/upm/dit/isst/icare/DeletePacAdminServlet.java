package es.upm.dit.isst.icare;

import java.io.IOException;
import java.util.List;

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


public class DeletePacAdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		req.getSession().setAttribute("lista_pac", false);
		
		String idStr = req.getParameter("id");
		System.out.println(idStr);
		
		PacientesDAO dao = PacientesDAOImpl.getInstance();
		AnomaliasDAO daoAn = AnomaliasDAOImpl.getInstance();
		AlarmsDAO daoAl = AlarmsDAOImpl.getInstancia();
		SensoresDAO daoSens = SensoresDAOImpl.getInstancia();
		List <Sensores> sens = daoSens.readPacientSensores(idStr);
		List <Alarms> als = daoAl.readPacientAlarms(idStr);
		List <Anomalias> ans = daoAn.readPacientAnomalies(idStr);
		for (int i = 0; i < ans.size(); i++){
			Anomalias an = ans.get(i);
			daoAn.remove(an.getId());
		}
		for (int i = 0; i < als.size(); i++){
			Alarms al = als.get(i);
			daoAl.delete(al.getId());
		}
		for (int i = 0; i < sens.size(); i++){
			Sensores sensor = sens.get(i);
			daoSens.remove(sensor.getId());
		}
		
		dao.delete(idStr);
		
		
		resp.sendRedirect("/admin");
	}
	
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Pacientes.class);
		ObjectifyService.register(Anomalias.class);
		ObjectifyService.register(Alarms.class);
		ObjectifyService.register(Sensores.class);
	}

}