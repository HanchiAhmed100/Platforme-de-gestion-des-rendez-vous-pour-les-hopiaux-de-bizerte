package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import org.json.JSONObject;
//import Models.Hopital;

public class Select {
	
private Connection con=null;
	
	public Select() {
		this.con = Connect.getConnetion();
	}
	
	public ResultSet HospitalList(String specialite) {
	
		 try{
			 PreparedStatement statement = con.prepareStatement("SELECT hopital.ville,hopital.nom,hopital.id  FROM secrataire join hopital on (hopital.id=secrataire.hopitalid) WHERE secrataire.specialite= ? ");
			 statement.setString(1, specialite);
			 ResultSet rs = statement.executeQuery();
			 return rs;
		}catch (Exception e) {
    	   System.out.println(e);
    	   return null;
		}
	}
	
	public ResultSet RDV(String specialite) {
		
		 try{
			 PreparedStatement statement = con.prepareStatement("SELECT hopital.ville,hopital.nom,hopital.id  FROM secrataire join hopital on (hopital.id=secrataire.hopitalid) WHERE secrataire.specialite= ? ");
			 statement.setString(1, specialite);
			 ResultSet rs = statement.executeQuery();
			 if(rs.next()) {
				 return rs;
			 }else {
				 return null;
			 }
		}catch (Exception e) {
   	   System.out.println(e);
   	   return null;
		}
	}
	public ResultSet RdvEnAttente() {	
		 try{
			 PreparedStatement statement = con.prepareStatement("SELECT count(*) FROM rdv join users on (rdv.patientId = users.id) where RdvValidation=0");
			 ResultSet rs = statement.executeQuery();
			 if(rs.next()) {
				 return rs;
			 }else {
				 return null;
			 }
		}catch (Exception e) {
	  	   System.out.println(e);
	  	   return null;
		}
	}

	public ResultSet RdvAnnuler() {	
		 try{
			 PreparedStatement statement = con.prepareStatement("SELECT count(*) FROM rdv join users on (rdv.patientId = users.id) where RdvValidation=1");
			 ResultSet rs = statement.executeQuery();
			 if(rs.next()) {
				 return rs;
			 }else {
				 return null;
			 }
		}catch (Exception e) {
	  	   System.out.println(e);
	  	   return null;
		}
	}
	public ResultSet RdvEffectuer() {	
		 try{
			 PreparedStatement statement = con.prepareStatement("SELECT count(*) FROM rdv join users on (rdv.patientId = users.id) where RdvValidation=2");
			 ResultSet rs = statement.executeQuery();
			 if(rs.next()) {
					 rs.getString(1);
			 return rs;
			 }else {
				 return null;
			 }
		}catch (Exception e) {
	  	   System.out.println(e);
	  	   return null;
		}
	}
	public ResultSet RdvByHospital(String h) {
		 try{
			 PreparedStatement statement = con.prepareStatement("SELECT count(*) FROM rdv join hopital on (hopital.id=rdv.hopitalid) WHERE hopital.id= ?");
			 statement.setString(1, h);
			 ResultSet rs = statement.executeQuery();
			 if(rs.next()) {
				 rs.getString(1);
		 return rs;
		 }else {
			 return null;
		 }
		}catch (Exception e) {
   	   System.out.println(e);
   	   return null;
		}
	}

	public ResultSet RdvByService(String h) {
		
		 try{
			 PreparedStatement statement = con.prepareStatement("SELECT Count(*) FROM rdv WHERE Service =?");
			 statement.setString(1, h);
			 ResultSet rs = statement.executeQuery();
			 if(rs.next()) {
				 rs.getString(1);
		 return rs;
		 }else {
			 return null;
		 }
		}catch (Exception e) {
  	   System.out.println(e);
  	   return null;
		}
	}
//    public List<String> xxx(String specialite){
//    	List<String> list = new ArrayList<>();
//        try {
//            PreparedStatement statement = con.prepareStatement("SELECT hopital.ville,hopital.nom  FROM secrataire join hopital on (hopital.id=secrataire.hopitalid) WHERE secrataire.specialite= ? ");
//            statement.setString(1, specialite);
//            ResultSet rs = statement.executeQuery();
//            int i=0;
//            while(rs.next()){
//            	list.add(rs.getString("nom"));
//            	list.add(rs.getString("ville"));
//            }
//        } catch (Exception e) {
//        	
//        }
//        return list;
//    }
/*	
	public JSONObject xxx(String specialite){
		JSONObject obj = new JSONObject();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT hopital.ville,hopital.nom  FROM secrataire join hopital on (hopital.id=secrataire.hopitalid) WHERE secrataire.specialite= ? ");
            statement.setString(1, specialite);
            ResultSet rs = statement.executeQuery();
            int i=0;
            while(rs.next()){
            	obj.put("nom",rs.getString("nom"));
            	obj.put("ville",rs.getString("ville"));
            }
        } catch (Exception e) {
        	
        }
        
        return obj;
    }
*/
	
}
