package es.upm.dit.isst.icare;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.*;
import es.upm.dit.isst.icare.model.Login;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	LoginDAO dao = LoginDAOImpl.getInstancia();

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
		String name = checkNull(req.getParameter("name"));
		String password= checkNull(req.getParameter("password"));
		
		String passMD5=this.sha256(password);
		System.out.println(passMD5);
		
		
		Login user_log = dao.readUser(name); //admin devuelve null!!!!
		
		if (name.equals("admin")&&password.equals("admin")){
			String admin = "admin";
			req.getSession().setAttribute("alerta", false);
			req.getSession().setAttribute("usuario", admin);
			
			resp.sendRedirect("/admin");
		} 
		else if (user_log == null){
			req.getSession().setAttribute("alerta", true);
			RequestDispatcher view = req.getRequestDispatcher("login.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else {
			if (passMD5.equals(user_log.getPasswd())){
				
				req.getSession().setAttribute("alerta", false);	
				req.getSession().setAttribute("usuario", name);
				
				resp.sendRedirect("/main");
			} else {
				if(name.equals("")){
					req.getSession().setAttribute("alerta", false);	
					
				}else{
					req.getSession().setAttribute("alerta", true);	
				}
				
				
				//System.out.println("Entramos en else");
				
				RequestDispatcher view = req.getRequestDispatcher("login.jsp");
				try {
					view.forward(req, resp);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
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

	private String checkNull(String s) {
		if (s== null){
			return "";
		}
		return s;
	}
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Login.class);
	}

}