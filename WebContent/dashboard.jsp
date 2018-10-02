<%@page import="java.sql.ResultSet"%>
<%@page import="org.apache.catalina.Session" %>
<%@page import="connection.*" %>
<%@page import="Models.Secretaire"%>

<%
	if(session.getAttribute("id") == null || session.getAttribute("id") == "" ){
		response.sendRedirect("adminlogin.html");
		return ;
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/uikit.min.css">
<title>Insert title here</title>
</head>
<body>
<%
	Secretaire p = null ;
	String id = session.getAttribute("id").toString();
	LoginService Ls = new LoginService();
	RdvPatient Ps =  new RdvPatient();
%>

    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span> 
                </button>
                <a class="navbar-brand" href="index.html">Accueil</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="statistique.jsp">Statistique</a></li>
                    <li><a href="DemoSession">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <br><br><br>
<div class="container">
  <h2>Vos info</h2>
  <table class="table">
    <thead>
      <tr>

        <th>Nom</th>
        <th>Prenom</th>
        <th>Adresse Mail</th>
       	<th>Adresse</th>
        <th>Telephone</th>
      </tr>
    </thead>
    <tbody>
      <tr>
      <% 	ResultSet rs = Ls.getinfo(id);
      	do{ %>
			        <td><%= rs.getString("nom") %></td>
			        <td><%= rs.getString("prenom") %></td>
			        <td><%= rs.getString("mail") %></td>
			<% }while(rs.next()); %>
 
      </tr>
    </tbody>
  </table>
  
  <div class="container">
  <h2>Rendez-vous</h2>
  <table class="table">
    <thead>
      <tr>

        <th>Nom</th>
        <th>Prenom</th>
        <th>ville</th>
        <th>tel</th>
        <th>date</th>
        <th>Service</th>
        <th>Hopital</th>
		<th>Etat</th>
        <th>Action</th>
      
      </tr>
    </thead>
    <tbody>
      <% 	ResultSet r = Ps.RdvBySect(id);
      	do{ %>	<tr>
			        <td><%= r.getString(24) %></td>
			        <td><%= r.getString(25) %></td>
			        <td><%= r.getString(26) %></td>
			        <td><%= r.getString(27) %></td>
     			    <td ><%= r.getString(17) %></td>
 				    <td id="service"><%= r.getString(7) %></td>
     			    <td id="hopital"><%= r.getString(9) %></td>
     			    <td><% if(Integer.parseInt(r.getString(19)) == 0){ %> En attente <% }else if(Integer.parseInt(r.getString(19)) == 1){ %> Annuler <% }else{ %> Rendez-vous a été effectuer<% } %></td>
     			    <td><% if(Integer.parseInt(r.getString(19)) == 0){ %><a onClick="supp(<%= r.getString(13) %>)"> Annuler Rendez-vous</a> <a onClick="acc(<%= r.getString(13) %>)"> Rendez-vous effectuer </a> <% }else{ %>  <% } %> </td>
			</tr>
			<% }while(r.next()); %>
 
      
    </tbody>
  </table>
  <hr> 
	<div class="uk-section">
	<h2>Ajouter un rendez-vous</h2>
	<form method="post" action="" >
		<label>Nom</label>
		<input type="text" name="nom" class="uk-input">
		<label>Prenom</label>
		<input type="text" name="prenom" class="uk-input">
		<label>ville</label>
		<input type="text" name="ville" class="uk-input">
		<label>Tel</label>
		<input type="text" name="tel" class="uk-input">
		<label>Date</label>
		<input type="date" id="dat" name="dat" class="uk-input">
		<input type="hidden" id="ser">
		<input type="hidden" id="hop">
	</form>
	</div>
</div>
<script src="js/jquery-2.1.1.js"></script>
<script type="text/javascript">
	function supp(id){
		$.post("./SuppRdv",{id:id});
		location.reload();
	}
	function acc(id){
		$.post("./AccRdv",{id:id});
		location.reload();
	}
	
	$(document).ready(function() {
		var service = $('#service').text();
		var hopital = $('#hopital').text();
		
		$('#ser').attr("name",service);
		$('#hop').attr("name",hopital);
		
	    var now = new Date();
	    var day = ("0" + now.getDate()).slice(-2);
	    var month = ("0" + (now.getMonth() + 1)).slice(-2);

	    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;

	    $('#dat').val(today);
	    $('#dat').attr("min", today);
	
	});
</script>
</body>
</html>