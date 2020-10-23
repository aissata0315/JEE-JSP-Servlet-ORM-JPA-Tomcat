package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IRole;
import dao.IVillage;
import dao.RoleImpl;
import dao.VillageImpl;
import entities.Role;
import entities.Village;


@WebServlet("/VillageServlet")
public class VillageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
private IVillage villagedao;
	
	@Override
	public void init() throws ServletException {
		villagedao = new VillageImpl();
	}
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("village.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nomVillage").toString();
		Village village = new Village();
		village.setNom(nom);
		
		villagedao.add(village);
		
	}

}
