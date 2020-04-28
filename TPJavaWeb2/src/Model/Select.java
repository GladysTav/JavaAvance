package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	public static String[] main() {
		// TODO Auto-generated method stub
		String[] tab;
		try { 
			String strClassName = "com.mysql.jdbc.Driver";
			String dbName= "univcergy22"; 
			String login= "root"; 
			String motdepasse= ""; 
			String strUrl = "jdbc:mysql://localhost:3306/"+dbName+"?autoReconnect=true&useSSL=false";

			
			String str = "SELECT prenom, login, statut, age FROM acces;";
			
			Class.forName(strClassName);
			Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);  
			Statement stLogin = conn.createStatement();
			
			ResultSet rsLogin = stLogin.executeQuery(str);
			
			rsLogin.last(); 
			//on récupère le numéro de la ligne 
			int nombreLignes = rsLogin.getRow(); 
			tab = new String[rsLogin.getRow()*4];
			//on replace le curseur avant la première ligne 
			rsLogin.beforeFirst(); 
			
			Integer i=0;
			while(rsLogin.next()) {
				tab[i] = rsLogin.getString("prenom");
				tab[i+1] = rsLogin.getString("login");
				tab[i+2] = rsLogin.getString("statut");
				tab[i+3] = rsLogin.getString("age");
				i+=4;
			}
			conn.close();
			return tab;
		}
		catch(ClassNotFoundException e) {  
			System.err.println("Driver non chargé !");  e.printStackTrace();
		} catch(SQLException e) {
			System.err.println("Erreur : ");  e.printStackTrace();
		}
		return tab=null;
	}
}
