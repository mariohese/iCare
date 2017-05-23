package es.upm.dit.isst.icare;

import java.io.IOException;
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
import es.upm.dit.isst.icare.dao.RecursosDAO;
import es.upm.dit.isst.icare.dao.RecursosDAOImpl;
import es.upm.dit.isst.icare.model.Alarms;
import es.upm.dit.isst.icare.model.Pacientes;
import es.upm.dit.isst.icare.model.Recursos;

public class AlarmManagementServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
		RequestDispatcher view = req.getRequestDispatcher("alarm.jsp");
		view.forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		req.getSession().setAttribute("urgencia", false);
		req.getSession().setAttribute("info", false);
		req.getSession().setAttribute("alan", false);
		req.getSession().setAttribute("cont", false);
		req.getSession().setAttribute("sens", false);

		
		//id de la alarma
		String idStr = req.getParameter("id");
		String op = req.getParameter("op");
		System.out.println(idStr);
		
		//alarma generada
		AlarmsDAO daoAl = AlarmsDAOImpl.getInstancia();
		Alarms alarma = daoAl.readAlarmById(idStr);
		alarma.setEstado("Siendo atendida.");
		alarma.setOperador(op);
		daoAl.update(alarma);
		
		System.out.println(String.valueOf(alarma.getIdPaciente()));
		
		//paciente asociado a la alarma generada
		PacientesDAO daoPac = PacientesDAOImpl.getInstance();
		Pacientes paciente = daoPac.readId(alarma.getIdPaciente());
		
		RecursosDAO daoRec = RecursosDAOImpl.getInstancia();
		List <Recursos> recursos = daoRec.readAlarmResource(alarma.getLocalizacion());
		int num_rec = recursos.size();
		
		req.getSession().setAttribute("num_rec", num_rec);
		req.getSession().setAttribute("recursos", recursos);
		req.getSession().setAttribute("al", alarma);
		req.getSession().setAttribute("id_al", idStr);
		req.getSession().setAttribute("pac", paciente);
		
		RequestDispatcher view = req.getRequestDispatcher("alarm_manag.jsp");
		view.forward(req, resp);
		
		
	}

	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Pacientes.class);
		ObjectifyService.register(Alarms.class);
		ObjectifyService.register(Recursos.class);
	}
	
}
