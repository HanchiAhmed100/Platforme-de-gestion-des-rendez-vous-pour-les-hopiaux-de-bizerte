package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Models.Patient;
import Models.RDV;
import Models.Secretaire;


public class LoginService {
	
	private Connection con=null;
	
	public LoginService() {
		super();
		this.con = Connect.getConnetion();
	}
	

    public int doLogin(String username, String password){
        try {
            PreparedStatement statement = con.prepareStatement("SELECT id FROM users WHERE USERNAME = ? AND PASSWORD = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
            	int id = rs.getInt("Id");
                return id;
            }else{
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int doSectLogin(String username,String password) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT id FROM secrataire WHERE mail = ? AND PASSWORD = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
            	int id = rs.getInt("Id");
                return id;
            }else{
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
    
	public ResultSet getinfo(String id) {
		try {

			PreparedStatement statement = con.prepareStatement("SELECT * FROM secrataire WHERE id = ?");
			statement.setString(1,id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				return rs;
			}else{
				return null;
			}
		}catch(Exception e) {
			return null;
		}	
	}
	
    
    public Patient GetPatients(String id){
        try {
        	
            PreparedStatement statement = con.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
            	Patient p = new Patient
    			(rs.getString("id"),rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),rs.getString("adresse"),rs.getString("tel"),rs.getString("mail"));
            	return p;

            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public ResultSet GetRdv(String id) {
    	try {
    		PreparedStatement statement =  con.prepareStatement("SELECT rdv.id,rdv.RdvDate,rdv.Service,rdv.RdvValidation,hopital.nom,hopital.id FROM rdv JOIN hopital on (rdv.hopitalId=hopital.id) WHERE  rdv.Patientid =? order by RdvDate");
    		statement.setString(1, id);
    		ResultSet rs =statement.executeQuery();
    		if(rs.next()) {
    			return rs;
    		}else {
    			return null;
    		}
    	}catch(Exception e) {
    		return null;
    	}
    }
    
    
    public ResultSet GetAllPatients(){
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM users ");
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
}


