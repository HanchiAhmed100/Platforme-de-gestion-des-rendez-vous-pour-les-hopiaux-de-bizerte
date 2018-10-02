<%@page import="connection.RdvPatient" %>
<%@page import="java.sql.ResultSet"%>

<% 
	String ss = request.getParameter("nom");
	RdvPatient R = new RdvPatient();	
	ResultSet rs = R.GetHosInfo(ss);
    do{
%><div class="container">
        <div class="uk-grid-collapse uk-child-width-1-3@s uk-flex-middle" uk-grid>
            <div class="uk-background-cover" style="background-image: url('<%= rs.getString(4) %>');height:500px;min-height:500px"> </div>
	        <div class="uk-padding uk-padding-remove-top">
		         <h3>Nom : <%= rs.getString(2) %></h3>
		          <h3 >Ville :<%= rs.getString(3) %></h4>
	         </div>
	         <div class="uk-background-cover" style="height:500px;min-height:500px">
	         	<%= rs.getString(5) %>
	         </div>
            </div>
        </div>
        </div>
<% }while(rs.next());%>