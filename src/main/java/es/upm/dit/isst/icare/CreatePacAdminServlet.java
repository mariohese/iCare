package es.upm.dit.isst.icare;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.googlecode.objectify.ObjectifyService;

import es.upm.dit.isst.icare.dao.PacientesDAO;
import es.upm.dit.isst.icare.dao.PacientesDAOImpl;
import es.upm.dit.isst.icare.model.Pacientes;


public class CreatePacAdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String name = checkNull(req.getParameter("name"));
		String apell = checkNull(req.getParameter("apell"));
		String edadn = checkNull(req.getParameter("edad")); 
		String nac = checkNull(req.getParameter("nac"));
		String dnin = checkNull(req.getParameter("dni"));
		String nussn = checkNull(req.getParameter("nuss"));
		String dir = checkNull(req.getParameter("dir"));
		String ciudad = checkNull(req.getParameter("ciudad"));
		String cpn = checkNull(req.getParameter("cp"));
		String est = checkNull(req.getParameter("est"));
		String enf = checkNull(req.getParameter("enf"));
		String disc = checkNull(req.getParameter("disc"));
		String vive = checkNull(req.getParameter("vive"));
		String nomcuid = checkNull(req.getParameter("nombcuid"));
		String apllcuid = checkNull(req.getParameter("apllcuid"));
		String tlfcuidn = checkNull(req.getParameter("tlfcuid"));
		String nomfam = checkNull(req.getParameter("nombfam"));
		String apllfam = checkNull(req.getParameter("apllfam"));
		String tlffamn = checkNull(req.getParameter("tlffam"));
		String aguaa = checkNull(req.getParameter("agua"));
		
		int edad = Integer.parseInt(edadn);
		int cp = Integer.parseInt(cpn);
		int agua = Integer.parseInt(aguaa);

		//MIRAR
		PacientesDAO dao = PacientesDAOImpl.getInstance();
		dao.create(name, apell, dnin, nussn, edad, nac, dir, ciudad, cp, est, enf, disc, vive, nomcuid, apllcuid, tlfcuidn, nomfam, apllfam, tlffamn, agua);
		
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
	
	@Override
	public void init() throws ServletException {
		ObjectifyService.register(Pacientes.class);
	}

}