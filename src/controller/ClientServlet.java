package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Client;
import dao.ClientImpl;
import dao.IClient;
import entities.Village;

 
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private IClient clientdao;
	private Village villageChoisi;
	private int villageid;
   
	
	@Override
	public void init() throws ServletException {
		clientdao = new ClientImpl();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Village> villages =  clientdao.village();
		System.out.println(villages);
		request.setAttribute("villages",villages);
		request.getRequestDispatcher("/client.jsp").forward(request, response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomFamille = request.getParameter("nomFamille").toString();
		String telephone = request.getParameter("numeroTelephone").toString();
		Client client = new Client();
		client.setNom(nomFamille);
		client.setTelephone(telephone);
		 villageid = Integer.parseInt(request.getParameter("villageid"));
        villageChoisi = clientdao.getVillage(villageid);

		client.setVillage(villageChoisi);
		
		clientdao.add(client);
		
	}

}
