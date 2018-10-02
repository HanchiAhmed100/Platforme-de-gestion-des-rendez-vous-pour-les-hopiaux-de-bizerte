package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static Connection connection;
	
    static {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
    	}catch(ClassNotFoundException c) {
    		System.out.println("Probleme de pilote de base de donn�e");
    		System.out.println(c.getMessage());
    	}catch(SQLException sql) {
    		System.out.println("Probleme de connexion a la base de donn�e");
    		System.out.println(sql.getMessage());
    	}
    }
    
    public static Connection getConnetion() {
    	return connection;
    }
}
