package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanJsp;
import dao.DaoLogin;


public class LogarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private DaoLogin daoLogin = new DaoLogin();
	
    public LogarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		
		BeanJsp beanJsp = new BeanJsp();
		
		String login = (request.getParameter("login"));
		String senha = (request.getParameter("senha"));
		
		if (daoLogin.validarLogin(login, senha)){
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.xhtml");
			dispatcher.forward(request, response);
			
		}
		else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);	
			} 
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
