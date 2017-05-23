package es.upm.dit.isst.icare;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.LoginDAO;
import es.upm.dit.isst.icare.dao.LoginDAOImpl;
import es.upm.dit.isst.icare.model.Login;


public class DeleteOpAdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		req.getSession().setAttribute("lista_op", false);
		
		String idStr = req.getParameter("id");
		System.out.println(idStr);
		
		LoginDAO dao = LoginDAOImpl.getInstancia();
		
		dao.delete(idStr);
		
		
		resp.sendRedirect("/admin");
	}
	
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Login.class);
	}

}