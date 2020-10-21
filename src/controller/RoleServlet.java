package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IRole;
import dao.RoleImpl;
import entities.Role;

@WebServlet(urlPatterns = "/Role", name = "role")
public class RoleServlet  extends HttpServlet{
	
	private IRole roledao;
	
	@Override
	public void init() throws ServletException {
		roledao = new RoleImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.getWriter().print("ok");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rol = req.getParameter("role").toString();
		Role role = new Role();
		role.setPoste(rol);
		
		int ok = roledao.add(role);
		resp.getWriter().println(ok);
	}
	

}
