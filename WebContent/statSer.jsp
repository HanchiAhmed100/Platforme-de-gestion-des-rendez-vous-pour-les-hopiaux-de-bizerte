<%@page import="connection.Select" %>
<%@page import="java.sql.ResultSet"%>

	<%
	String param = request.getParameter("param");
	Select s = new Select();	
	ResultSet rs = s.RdvByService(param);
    do{
    %>
    <div class="container">
    <h3>Nombre de Rendez-vous : <%= rs.getString(1) %></h3>
    </div>

    <% }while(rs.next()); %>