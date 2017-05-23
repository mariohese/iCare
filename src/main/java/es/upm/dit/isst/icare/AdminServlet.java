package es.upm.dit.isst.icare;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.LoginDAO;
import es.upm.dit.isst.icare.dao.LoginDAOImpl;
import es.upm.dit.isst.icare.dao.PacientesDAO;
import es.upm.dit.isst.icare.dao.PacientesDAOImpl;
import es.upm.dit.isst.icare.model.Login;
import es.upm.dit.isst.icare.model.Pacientes;


public class AdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
		req.getSession().setAttribute("formulario_op", false);
		req.getSession().setAttribute("lista_op", false);
		req.getSession().setAttribute("formulario_pac", false);
		req.getSession().setAttribute("lista_pac", false);
		req.getSession().setAttribute("sinclickar", true);
		
		LoginDAO daoLog = LoginDAOImpl.getInstancia();
		List <Login> logins = daoLog.read();
		req.getSession().setAttribute("logins_sin", logins);
		
		PacientesDAO daoPat = PacientesDAOImpl.getInstance();
		List <Pacientes> pacs = daoPat.listPacientes();
		req.getSession().setAttribute("pacs_sin", pacs);
		
		RequestDispatcher view = req.getRequestDispatcher("admin.jsp");
		view.forward(req, resp);
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		req.getSession().setAttribute("formulario_op", false);
		req.getSession().setAttribute("lista_op", false);
		req.getSession().setAttribute("formulario_pac", false);
		req.getSession().setAttribute("lista_pac", false);
		req.getSession().setAttribute("sinclickar", false);


		String crear_op = checkNull(req.getParameter("crear_op"));
		String borrar_op = checkNull(req.getParameter("borrar_op"));
		
		String crear_pac = checkNull(req.getParameter("crear_pac"));
		String borrar_pac = checkNull(req.getParameter("borrar_pac"));
		
		if (crear_op.equals("crear_op")){
			System.out.println("Entra en crear_op");
			req.getSession().setAttribute("formulario_op", true);
			RequestDispatcher view = req.getRequestDispatcher("admin.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (borrar_op.equals("borrar_op")){
			System.out.println("Entra en borrar_op");
			req.getSession().setAttribute("lista_op", true);
			
			LoginDAO dao = LoginDAOImpl.getInstancia();
			List <Login> logins = dao.read();
			req.getSession().setAttribute("logins", logins);
			RequestDispatcher view = req.getRequestDispatcher("admin.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (crear_pac.equals("crear_pac")){
			System.out.println("Entra en crear_pac");
			req.getSession().setAttribute("formulario_pac", true);
			RequestDispatcher view = req.getRequestDispatcher("admin.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (borrar_pac.equals("borrar_pac")){
			System.out.println("Entra en borrar_pac");

			req.getSession().setAttribute("lista_pac", true);
			
			PacientesDAO dao = PacientesDAOImpl.getInstance();
			List <Pacientes> pacs = dao.listPacientes();
			
			
			req.getSession().setAttribute("pacs", pacs);
			RequestDispatcher view = req.getRequestDispatcher("admin.jsp");
			try {
				System.out.println("Sale de borrar_pac");

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
		ObjectifyService.register(Login.class);
		ObjectifyService.register(Pacientes.class);
	}

}