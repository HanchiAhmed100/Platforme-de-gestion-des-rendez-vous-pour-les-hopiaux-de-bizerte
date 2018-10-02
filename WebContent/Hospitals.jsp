<%@page import="java.sql.ResultSet"%>
<%@page import="Models.Hopital " %>
<%@page import="connection.Select" %>


	     <label class="uk-form-label" for="form-horizontal-select">Choisir l'hopital : </label>
        	<div class="uk-form-controls">
            <select class="uk-select" id="form-horizontal-select" name="hopi" onclick="f3()">

<%
	String specialite =	request.getParameter("spec").toString();
	Hopital h;
	Select s = new Select();
	ResultSet rs = s.HospitalList(specialite);

	while(rs.next()){
%>
	<option value='<%= rs.getString("id") %>'><%= rs.getString("nom") %> - <%= rs.getString("ville") %> </option>
<% } %>
       		</select>
        	</div>
       