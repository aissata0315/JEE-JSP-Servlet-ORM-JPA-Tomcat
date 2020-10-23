package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IUser;
import dao.Userimpl;
import entities.Role;
import entities.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUser userdao;
	
	@Override
	public void init() throws ServletException {
		userdao = new Userimpl();
	}
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email").toString();
		String password = req.getParameter("password").toString();
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		if (userdao.login(email, password)!= null) {
			
			req.getRequestDispatcher("accueil.jsp").forward(req, resp);;
			
		}else {
			System.out.println("login ou mot de passe incorect");
			
	}
		
		
		
		
		
		
	}

}
