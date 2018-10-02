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
 * Servlet implementation class SetRdvByAdmin
 */
@WebServlet("/SetRdvByAdmin")
public class SetRdvByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetRdvByAdmin() {
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
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String ville = request.getParameter("ville");
		String tel = request.getParameter("tel");
		String dat = request.getParameter("dat");
		String service = request.getParameter("service");
		String hopital = request.getParameter("hopital");
		
		
		/*RDV R = new RDV(PatientVille,serv,hopi,dat,PatientId);
		InsertRDV insert = new InsertRDV();
		if(insert.insert(R)) {
			response.sendRedirect("welcome.jsp");
		}*/
		System.out.println( R.toString() );
	}

}
