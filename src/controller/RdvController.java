package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.RDV;
import connection.InsertRDV;

/**
 * Servlet implementation class RdvController
 */
@WebServlet("/RdvController")
public class RdvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RdvController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String PatientVille = request.getParameter("PatientVille");
		String serv = request.getParameter("serv");
		String hopi = request.getParameter("hopi");
		String dat = request.getParameter("dat");
		String PatientId = request.getParameter("PatientId");
		RDV R = new RDV(PatientVille,serv,hopi,dat,PatientId);
		InsertRDV insert = new InsertRDV();
		if(insert.insert(R)) {
			response.sendRedirect("welcome.jsp");
		}
		System.out.println( R.toString() );
	}

}
