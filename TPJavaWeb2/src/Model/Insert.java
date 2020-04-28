package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;


public abstract class Insert {

	/**
	 * @param args
	 */
	public static void main(String nom, String log, String age) {
		// TODO Auto-generated method stub
		try { 
			String strClassName = "com.mysql.jdbc.Driver";
			String dbName= "univcergy22"; 
			String login= "root"; 
			String motdepasse= ""; 
			String strUrl = "jdbc:mysql://localhost:3306/"+dbName+"?autoReconnect=true&useSSL=false";

			
			String strInsert = "INSERT INTO acces "
				+ "(prenom, login, age, password, statut) "
				+ "VALUES ('"+nom+"', '"+log+"', "+age+", '0123', 'Queen');";
			
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
	public static void main(String nom, String log, String age,String pass, String sta) {
		// TODO Auto-generated method stub
		try { 
			String strClassName = "com.mysql.jdbc.Driver";
			String dbName= "univcergy22"; 
			String login= "root"; 
			String motdepasse= ""; 
			String strUrl = "jdbc:mysql://localhost:3306/"+dbName+"?autoReconnect=true&useSSL=false";

			
			String strInsert = "INSERT INTO acces "
				+ "(prenom, login, age, password, statut) "
				+ "VALUES ('"+nom+"', '"+log+"', "+age+", '"+pass+"', '"+sta+"');";
			
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
