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
 * Servlet implementation class adminloginservlet
 */
@WebServlet("/adminloginservlet")
public class adminloginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminloginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession mypostsession = request.getSession();
		HttpSession myIdsession = request.getSession();
		mypostsession.removeAttribute("Sect");
		myIdsession.removeAttribute("id");
		response.sendRedirect("adminlogin.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+" "+password);
		LoginService lS = new LoginService();
		int id = lS.doSectLogin(username, password);
		if(id != 0) {
			HttpSession myIdsession = request.getSession();
			myIdsession.setAttribute("id",id);
			HttpSession mypostsession = request.getSession();
			mypostsession.setAttribute("Sect","sect");
			response.sendRedirect("dashboard.jsp");
			System.out.println(myIdsession.getAttribute("id").toString());
			System.out.println(mypostsession.getAttribute("Sect").toString());
		}else {
			request.setAttribute("message", "mot de passe invalidde !! <br>");
			request.getRequestDispatcher("adminlogin.html").forward(request, response);
			System.out.println("eerrr");
		}
	}

}
