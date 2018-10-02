package connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.RDV;

public class InsertRDV {
	private Connection con=null;
	
	public InsertRDV() {
		super();
		this.con = Connect.getConnetion();
	}
	
	public boolean insert(RDV r) {
		try {
			PreparedStatement statement = con.prepareStatement("INSERT INTO rdv (patientVille,Service,hopitalId,RdvDate,PatientId,RdvValidation) VALUES (?,?,?,?,?,?)");
			statement.setString(1, r.getPatientVille());
			statement.setString(2, r.getService());
			statement.setString(3, r.getHopitalId());
			statement.setString(4, r.getRdvDate());
			statement.setString(5, r.getPatientId());
			statement.setString(6, r.getRdvValidation());
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
	public ResultSet GetRDV() {
		try {
			Statement statement = con.createStatement();
			String sql ="SELECT * FROM RDV JOIN HOPITAL ON rdv.hopitalId = hopital.id order by hopital.id";
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				return rs;
			}else {
				return rs;
			}
		}catch(SQLException sql) {
			sql.printStackTrace();
			return null;
		}

	}
	public void updateRdv(String id ) {
		try {
		PreparedStatement statement = con.prepareStatement("UPDATE rdv SET RdvValidation=1 WHERE id=?");
		statement.setString(1, id);
		statement.executeUpdate();
		System.out.println("update complet");
		}catch(SQLException sql) {
			sql.printStackTrace();
		}
	}
	public void SetRdv2(String id) {
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE rdv SET RdvValidation=2 WHERE id=?");
			statement.setString(1, id);
			statement.executeUpdate();
			System.out.println("update complet");
			}catch(SQLException sql) {
				sql.printStackTrace();
			}
	}
}
