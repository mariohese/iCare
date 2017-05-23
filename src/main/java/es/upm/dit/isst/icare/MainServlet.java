package es.upm.dit.isst.icare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.AlarmsDAO;
import es.upm.dit.isst.icare.dao.AlarmsDAOImpl;
import es.upm.dit.isst.icare.model.Alarms;
import es.upm.dit.isst.icare.model.Login;
import es.upm.dit.isst.icare.model.Pacientes;


public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	AlarmsDAO dao = AlarmsDAOImpl.getInstancia();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
		
		
		List <Alarms> alarms = dao.listAlarms();
		List <Alarms> alarmas_dia = new ArrayList <Alarms>();
		List <Alarms> alarmas_ordenadas = new ArrayList <Alarms>();
		
		//fecha actual
		Date dia_f = new Date();
		int dia_semana = dia_f.getDay();
		int dia_mes = dia_f.getDate();
		int mes = dia_f.getMonth();
		int year = dia_f.getYear();
		
		int comp_diasemana =0;
		int comp_diames =0;
		int comp_mes = 0;
		int comp_year=0;
		
		for (int i = 0; i < alarms.size(); i++){
			Date dateal = alarms.get(i).getFecha();
			comp_diasemana = dateal.getDay();
			comp_diames = dateal.getDate();
			comp_mes = dateal.getMonth();
			comp_year = dateal.getYear();
			if ((dia_semana == comp_diasemana) && (dia_mes == comp_diames) && (mes == comp_mes) && (year == comp_year)){
				Alarms alarma = alarms.get(i);
				alarmas_dia.add(alarma);
			}
		}
		
		//ordenamos las del dia de menor a mayor
		Collections.sort(alarmas_dia, new Comparator<Alarms>() {
			  public int compare(Alarms o1, Alarms o2) {
			      return o1.getFecha().compareTo(o2.getFecha());
			  }
		});
		
		//de mayor a menor
		for (int i = alarmas_dia.size() - 1; i >= 0; i--){
			alarmas_ordenadas.add(alarmas_dia.get(i));
		}

		
		req.getSession().setAttribute("alarms", alarmas_ordenadas);
		
		RequestDispatcher view = req.getRequestDispatcher("main.jsp");
		view.forward(req, resp);
		
	}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Alarms.class);
		ObjectifyService.register(Login.class);
		ObjectifyService.register(Pacientes.class);
	}

}