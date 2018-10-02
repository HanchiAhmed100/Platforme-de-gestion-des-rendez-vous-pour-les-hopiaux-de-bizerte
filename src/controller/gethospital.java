package controller;

import java.io.IOException;
/*import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import connection.Select;*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class gethospital
 */
@WebServlet("/gethospital")
public class gethospital extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gethospital() {
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
	/*	response.setContentType("application/json");
		String specialite = request.getParameter("spec").toString();
		JSONObject obj;
		Select s =  new Select();
		obj = s.xxx(specialite);
		PrintWriter resp = response.getWriter();
		resp.print(obj);
		
		request.setAttribute("myresult", rs);
		request.getRequestDispatcher("comp.jsp").forward(request, response);
	*/
		request.setAttribute("spec", request.getParameter("spec"));
		request.getRequestDispatcher("Hospitals.jsp").forward(request, response);
		}

}
