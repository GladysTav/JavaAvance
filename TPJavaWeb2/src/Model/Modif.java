package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;


public abstract class Modif {

	/**
	 * @param args
	 */
	public static void main(String champ, String id, String val) {
		// TODO Auto-generated method stub
		try { 
			String strClassName = "com.mysql.jdbc.Driver";
			String dbName= "univcergy22"; 
			String login= "root"; 
			String motdepasse= ""; 
			String strUrl = "jdbc:mysql://localhost:3306/"+dbName+"?autoReconnect=true&useSSL=false";

			
			String strInsert = "UPDATE acces SET "+champ+"='"+val+"' WHERE id="+id;
			
			Class.forName(strClassName);
			Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
			
			Statement stAddUser = conn.createStatement();  
			stAddUser.executeUpdate(strInsert);

			
			conn.close();
			}
			catch(ClassNotFoundException e) {  
				System.err.println("Driver non chargé !");  e.printStackTrace();
			} catch(SQLException e) {
				System.err.println("Erreur : ");  e.printStackTrace();
			}
	}

}
