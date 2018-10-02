package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RdvPatient {
	
	private Connection con;

	public RdvPatient() {
		super();
		this.con = Connect.getConnetion();
	}

	 public ResultSet RdvList(int id){
	        try {
	            PreparedStatement statement = con.prepareStatement("SELECT * FROM Rdv WHERE PatientId = ?");
	            statement.setInt(1,id);
	            ResultSet rs = statement.executeQuery();
	            if(rs.next()){
	            	return rs;
	            }else{
	                return null;
	            }
	        } catch (Exception e) {
	            return null;
	        }
    }
	 public void supp(String id){
	        try {
	            PreparedStatement statement = con.prepareStatement("DELETE FROM RDV WHERE id = ?");
	            System.out.println("supp"+ id);
	            statement.setString(1,id);
	            statement.executeUpdate();

	        } catch (Exception e) {
	        	System.out.println(e);
	        }
 }
	 
	 public ResultSet RdvBySect(String id ) {
		 try {
		 PreparedStatement statement = con.prepareStatement("select * from secrataire join hopital on (secrataire.hopitalid = hopital.id) join rdv on (hopital.id=rdv.hopitalId) join users on (users.id =rdv.PatientId) where secrataire.id = ? ");
		 //PreparedStatement statement = con.prepareStatement("select * from rdv join hopital on rdv.hopitalid = hopital.id join users on users.id=rdv.patientId join secrataire on secrataire.hopitalId =rdv.hopitalId where secrataire.id = ? ");

		 statement.setString(1,id);
         ResultSet rs = statement.executeQuery();
         if(rs.next()){
        	 System.out.println(rs);
        	 System.out.println(rs.getString(22));
         	return rs;
         }else{
             return null;
         }
		 }catch(Exception e) {
	            return null;
	        }
	 }
	 public ResultSet GetHosInfo(String nom) {
		 try {
			 PreparedStatement statement = con.prepareStatement("SELECT * FROM hopital where id = ?");
			 statement.setString(1,nom);
	         ResultSet rs = statement.executeQuery();
	         if(rs.next()){
	        	 return rs;
	         }else {
	        	 return null;
	         }
		 }catch(Exception e) {
			    return null;
		 }
	 }
}
