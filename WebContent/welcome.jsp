<%@page import="java.sql.ResultSet"%>
<%@page import="org.apache.catalina.Session" %>
<%@page import="connection.*" %>
<%@page import="Models.Patient"%>

<%
	if(session.getAttribute("id") == null || session.getAttribute("id") == "" ){
		response.sendRedirect("login.jsp");
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
	Patient p = null ;
	String id = session.getAttribute("id").toString();
	LoginService Ls = new LoginService();
	p = Ls.GetPatients(id);

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
                	<li><a><%= p.getNom() %> <%= p.getPrenom() %></a></li>                
                    <li><a href="DemoSession">Logout</a></li>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
<div class="container">
  <h2>Vos info</h2>
  <table class="table">
    <thead>
      <tr>
        <th>CIN</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Adresse Mail</th>
       	<th>Adresse</th>
        <th>Telephone</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><%= p.getCin() %></td>
        <td><%= p.getNom() %></td>
        <td><%= p.getPrenom() %></td>
        <td><%= p.getMail() %></td>
        <td><%= p.getAdresse() %></td>
        <td><%= p.getTel() %></td>
 
      </tr>
    </tbody>
  </table>
  <table class="table">
  	<thead>
  		<tr>
  			<th>Date du Rendez-vous</th>
  			<th>Hopital</th>
  			<th>Service</th>
			<th>Etat</th>
			<th>Action</th> 
			
  		</tr>	
  	</thead>
  		<tbody>

  		  	<% 	ResultSet rs = Ls.GetRdv(id);
  				if(rs == null){
  				%>  		<Tr>
					<td rowspan="4" class="text-center"> vous n'avez pas de rendez-vous</td>  				
  					</Tr>
  				<%
  				}else{
  					do{%>
				  		<Tr>		
				<td><%=  rs.getString("RdvDate") %></td>
				<td><a onclick="MapTheHospital(<%= rs.getString(6) %>)"><%= rs.getString("nom") %></a></td>
				<td><%=  rs.getString("Service") %></td>
				<td><% if(Integer.parseInt(rs.getString("RdvValidation")) == 0){  %> En attente  <% }else{ %> Rendez-vous effectuer  <% }%></td>	
				<td><a onclick="updateSupp(<%= rs.getInt(1)%>)">Annuler </a></td>
				</Tr>
					<% }while(rs.next());
				}%>
		
		</tbody>
  </table>

  	<section class="uk-section uk-section-muted uk-padding ">

<form class="uk-form-horizontal uk-margin-large" method="post" action="RdvController">
	<H3 class="uk-text-center">Pour la reservation d'un Rendez-vous veuillez remplir ce formulaire : </H3>
    <div class="uk-margin">
        <label class="uk-form-label" for="form-horizontal-select"> La région et l'organisme : </label>
        <div class="uk-form-controls">
            <input type="text" class="uk-input" name="PatientVille">
        </div>
    </div>
    <div class="uk-margin">
        <label class="uk-form-label" for="form-horizontal-select">Choisir Le service medicale : </label>
        <div class="uk-form-controls">
            <select class="uk-select" id="myselect" onchange="submitForm()" name="serv">
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


    <div class="uk-margin" id="load"></div>

	<div class="uk-margin bt2">
        <label class="uk-form-label" for="form-horizontal-select">Choisir la date du rendez-vous :</label>
        <div class="uk-form-controls">
        	<input type="date" id="dat" name="dat" class="uk-input" onchange="f2()">
        </div>
    </div> 	    

 	<div class="uk-margin uk-grid-small uk-child-width-auto uk-grid bt">
          <label><input class="uk-checkbox chk" type="checkbox" onclick="f1()" > Cliquer ici valider votre Rendez-vous </label>
     </div>
     <div><button class="uk-button uk-button-primary bt1"> valider </button> </div>
     <input type="hidden" name="PatientId" value="<%= p.getId() %>">
</form>
</section>
</div>
<div id="Map" class="uk-margin-top"> </div>
<script src="js/uikit.min.js"></script>

<script src="js/jquery-2.1.1.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
	    $('.bt').hide();
	    $('.bt1').hide();
	    $('.bt2').hide();
	    
	    var now = new Date();

	    var day = ("0" + now.getDate()).slice(-2);
	    var month = ("0" + (now.getMonth() + 1)).slice(-2);

	    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;

	    $('#dat').val(today);
	    $('#dat').attr("min", today);
	
	});
	function f2(){
	    $('.bt').show("slow");
	}
	function updateSupp(id){
		$.post("./updateSupp",{id:id});
		location.reload();
	}
	
	function MapTheHospital(nom){
		$("#Map").load("./maps.jsp",{nom:nom}).fadeIn("slow");
	
	}
	function submitForm(){
		$("#load").load("./Hospitals.jsp",{spec:$('#myselect').val()} ).fadeIn("slow");

	//	$.post("./gethospital",{spec:$('#spec').val()},function(data){
	//		parsed = JSON.parse(data);
	//		console.log(data)
	//	});
	}
	function f3(){
		$('.bt2').show("slow");
	}
	function f1(){
		if( $('.chk').checked = true){
			$('.bt1').show("slow");
		}
		else if( $('.chk').checked = false){
			$('.bt1').hide("slow");
		}
	}

</script>
</body>
</html>