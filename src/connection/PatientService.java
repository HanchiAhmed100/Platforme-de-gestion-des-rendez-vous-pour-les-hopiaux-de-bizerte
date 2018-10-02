package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Patient;
import Models.Secretaire;

public class PatientService {
	
	private Connection con=null;
	
	public PatientService() {
		super();
		this.con = Connect.getConnetion();
	}
	
	public boolean doRegistration(Patient p) {
		try {
			PreparedStatement statement = con.prepareStatement("INSERT INTO users (username,password,cin,nom,prenom,adresse,tel,mail) VALUES (?,?,?,?,?,?,?,?)");
			statement.setString(1, p.getUsername());
			statement.setString(2, p.getPassword());
			statement.setString(3, p.getCin());
			statement.setString(4, p.getNom());
			statement.setString(5, p.getPrenom());
			statement.setString(6, p.getAdresse());
			statement.setString(7, p.getTel());
			statement.setString(8, p.getMail());
			int numRows = statement.executeUpdate();
			if(numRows == 1) {
				System.out.println("Ajout avec success");
				return true;
			}else {
				return false;

			}
		}catch(SQLException sql) {
			sql.printStackTrace();
			return false;
		}
	}
	

	
    public ArrayList<Patient> getAllUsers() {
    	ArrayList<Patient> users = new ArrayList<Patient>();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Patient");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Patient p = new Patient();
                p.setId(rs.getString("id"));
                p.setNom(rs.getString("nom"));
                p.setAdresse(rs.getString("adresse"));
                p.setTel(rs.getString("tel"));   
                users.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return users;
    }

	
}
