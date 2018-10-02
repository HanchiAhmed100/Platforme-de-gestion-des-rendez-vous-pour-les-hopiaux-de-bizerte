<%@page import="java.sql.ResultSet"%>
<%@page import="org.apache.catalina.Session" %>
<%@page import="connection.*" %>


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
	String id = session.getAttribute("id").toString();

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
                    <li><a href="DemoSession">Logout</a></li>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <br><br><br>
<div class="container">
	<% 
    	Select s  = new Select();
    	ResultSet rs1 = s.RdvEffectuer(); 
    		do{
    	%>
	<h3> Nombre de Rendez-vous effectuer : <%= rs1.getString(1) %></h3>
		<% }while(rs1.next()); %>
</div>
<div class="container">
    	<% ResultSet rs2 = s.RdvEnAttente(); 
    		do{
    	%>
	<h3>  Nombre de Rendez-vous en attente : <%= rs2.getString(1) %></h3>
		<% }while(rs1.next()); %>
</div>
<div class="container">
    	<% ResultSet rs3 = s.RdvAnnuler(); 
    		do{
    	%>
	<h3>  Nombre de Rendez-vous annuler : <%= rs3.getString(1) %> </h3>

		<% }while(rs1.next()); %>
</div>
	<div class="container">
		 <div class="uk-margin">
        <label class="uk-form-label" for="form-horizontal-select">Choisir Le service medicale : </label>
        <div class="uk-form-controls">
            <select class="uk-select" id="myselect" onchange="statSer()" name="serv">
                <option value="Cardiologie">Cardiologie</option>
                <option value="Ophtalmologie">Ophtalmologie</option>
                <option value="Anatomie">Anatomie</option>
                <option value="Neurologie">Neurologie</option>
                <option value="Génétique">Génétique</option>
                <option value="biochimie">biochimie</option>
                <option value="hématologie">hématologie</option>
            </select>
        </div>
    </div>
	</div>
		<div id="load"></div>
	
	<div class="container">
		 <div class="uk-margin">
        <label class="uk-form-label" for="form-horizontal-select">Choisir l'hopital : </label>
        <div class="uk-form-controls">
            <select class="uk-select" id="myselect2" onchange="stathop()" name="serv">
                <option value="1">Bougatfa bizerte</option>
                <option value="2">Manzel bourguiba hopital</option>
                <option value="3">Azziza othmana</option>
            </select>
        </div>
    </div>
	

	<div id="load2"></div>
	
</body>

<script src="js/jquery-2.1.1.js"></script>
<script type="text/javascript">
	function statSer(){
		$("#load").load("./statSer.jsp",{param:$('#myselect').val()} ).fadeIn("slow");
	}

	function stathop(){
		$("#load2").load("./stathop.jsp",{param:$('#myselect2').val()} ).fadeIn("slow");
	}

</script>
</html>