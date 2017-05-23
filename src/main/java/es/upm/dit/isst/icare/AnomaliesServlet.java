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

import es.upm.dit.isst.icare.dao.AnomaliasDAO;
import es.upm.dit.isst.icare.dao.AnomaliasDAOImpl;
import es.upm.dit.isst.icare.model.Anomalias;
import es.upm.dit.isst.icare.model.Pacientes;


public class AnomaliesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	AnomaliasDAO dao = AnomaliasDAOImpl.getInstance();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	

		List <Anomalias> anomalia = dao.listAnomalias();
		List <Anomalias> an_dia = new ArrayList <Anomalias>();
		List <Anomalias> an_ordenadas = new ArrayList <Anomalias>();
		
		//dia actual
		Date dia_f = new Date();
		int dia_semana = dia_f.getDay();
		int dia_mes = dia_f.getDate();
		int mes = dia_f.getMonth();
		int year = dia_f.getYear();
		
		int comp_diasemana =0;
		int comp_diames =0;
		int comp_mes = 0;
		int comp_year=0;
		
		for (int i = 0; i < anomalia.size(); i++){
			Date datean = anomalia.get(i).getFecha();
			comp_diasemana = datean.getDay();
			comp_diames = datean.getDate();
			comp_mes = datean.getMonth();
			comp_year = datean.getYear();
			if ((dia_semana == comp_diasemana) && (dia_mes == comp_diames) && (mes == comp_mes) && (year == comp_year)){
				Anomalias an = anomalia.get(i);
				an_dia.add(an);
			}
		}
		
		//ordenamos las del dia de menor a mayor
		Collections.sort(an_dia, new Comparator<Anomalias>() {
			  public int compare(Anomalias o1, Anomalias o2) {
			      return o1.getFecha().compareTo(o2.getFecha());
			  }
		});
		
		//de mayor a menor
		for (int i = an_dia.size() - 1; i >= 0; i--){
			an_ordenadas.add(an_dia.get(i));
		}
		
		req.getSession().setAttribute("anomalias", an_ordenadas);
		
		RequestDispatcher view = req.getRequestDispatcher("anomalies_list.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Anomalias.class);
		ObjectifyService.register(Pacientes.class);
	}

}