package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.LoginService;

/**
 * Servlet implementation class DemoSession
 */
@WebServlet("/DemoSession")
public class DemoSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession mysession = request.getSession();
		HttpSession myIdsession = request.getSession();
		mysession.removeAttribute("username");
		myIdsession.removeAttribute("id");
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		LoginService lS = new LoginService();
		int id = lS.doLogin(username, password);
		if(id != 0) {
			HttpSession myIdsession = request.getSession();
			myIdsession.setAttribute("id",id);
			response.sendRedirect("welcome.jsp");
			System.out.println(myIdsession.getAttribute("id").toString());
		}else {
			request.setAttribute("message", "mot de passe invalidde !! <br>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
