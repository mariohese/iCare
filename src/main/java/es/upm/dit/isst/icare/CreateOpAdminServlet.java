package es.upm.dit.isst.icare;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.LoginDAO;
import es.upm.dit.isst.icare.dao.LoginDAOImpl;
import es.upm.dit.isst.icare.model.Login;


public class CreateOpAdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String name = checkNull(req.getParameter("name"));
		String passwd = checkNull(req.getParameter("passwd"));
		
		String passMD5=this.sha256(passwd);
		System.out.println(passMD5);
		
		//MIRAR
		LoginDAO dao = LoginDAOImpl.getInstancia();
		dao.create(name, passMD5);
		
		req.getSession().setAttribute("formulario_op", false);
		req.getSession().setAttribute("formulario_pac", false);
		resp.sendRedirect("/admin");
	}
	
	private String checkNull(String s) {
		if (s== null){
			return "";
		}
		return s;
	}
	
	private String sha256(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Login.class);
	}

}