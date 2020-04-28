package DAO;
import java.sql.*;

import Model.Acces;

public class DAOAcces {
	static Connection co;
	/*
	 * •	Une méthode qui permet de fermer cette connexion
		•	Une méthode Lister() qui permet de lister le contenu de la table en mode console
		•	Une méthode ajouter(int id, ….) qui permet d’ajouter un Accès, les paramètres sont les tuples de la table
		•	Un méthode supprimer(int id) qui permet de supprimer des accès, les paramètres sont l’identifiant du tuple.

	 */
	public DAOAcces() {
		// TODO Auto-generated constructor stub
		try{
			String strClassName = "com.mysql.jdbc.Driver";
			String dbName= "univcergy22"; 
			String login= "root"; 
			String motdepasse= ""; 
			String strUrl = "jdbc:mysql://localhost:3306/"+dbName+"?autoReconnect=true&useSSL=false";
	
			
			
			Class.forName(strClassName);
			Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
			
			
			conn.close();
		}
		catch(ClassNotFoundException e) {  
			System.err.println("Driver non chargé !");  e.printStackTrace();
		} catch(SQLException e) {
			System.err.println("Erreur : ");  e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void open(){
		try{
			String strClassName = "com.mysql.jdbc.Driver";
			String dbName= "univcergy22"; 
			String login= "root"; 
			String motdepasse= ""; 
			String strUrl = "jdbc:mysql://localhost:3306/"+dbName+"?autoReconnect=true&useSSL=false";
	
			
			
			Class.forName(strClassName);
			Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
			
			co = conn;
		}
		catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("ClassNotFoundException"); e.printStackTrace();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close() {
		// TODO Auto-generated method stub
		try {
			co.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String[] lister() {
		// TODO Auto-generated method stub
		String str = "SELECT prenom, login, statut, age FROM acces;";
		String[] tab;
		
		try{
			open();  
			Statement stLogin = co.createStatement();
			
			ResultSet rsLogin = stLogin.executeQuery(str);
			
			rsLogin.last(); 
			tab = new String[rsLogin.getRow()*4];
			rsLogin.beforeFirst(); 
			
			Integer i=0;
			while(rsLogin.next()) {
				tab[i] = rsLogin.getString("prenom");
				tab[i+1] = rsLogin.getString("login");
				tab[i+2] = rsLogin.getString("statut");
				tab[i+3] = rsLogin.getString("age");
				i+=4;
			}
			close();
			return tab;
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tab=null;
	}
	public static boolean ajouter(String prenom, String login, String age, String password, String statut) {//bool si return ok
		// TODO Auto-generated method stub
		try{
			open(); 
			String strInsert = "INSERT INTO acces "
			+ "(prenom, login, age, password, statut) "
			+ "VALUES ('"+prenom+"', '"+login+"', "+age+", '"+password+"', '"+statut+"');";
		
			Statement stAddUser = co.createStatement();  
			stAddUser.executeUpdate(strInsert);
			return true;
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public static boolean ajouterDAO(Acces a) {//bool si return ok
		// TODO Auto-generated method stub
		try{
			open(); 
			String strInsert = "INSERT INTO acces "
			+ "(prenom, login, age, password, statut) "
			+ "VALUES ('"+a.getPrenom()+"', '"+a.getLogin()+"', "+a.getAge()+", '"+a.getPassword()+"', '"+a.getStatut()+"');";
		
			Statement stAddUser = co.createStatement();  
			stAddUser.executeUpdate(strInsert);
			return true;
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public static boolean supprimer(String id) {
		// TODO Auto-generated method stub
		try{
			open(); 
			String strInsert = "DELETE FROM acces WHERE id ="+id+";";
			
			Statement stAddUser = co.createStatement();  
			stAddUser.executeUpdate(strInsert);
			
			close();
			return true;
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public static boolean supprimer(Acces a) {
		// TODO Auto-generated method stub
		try{
			open(); 
			String strInsert = "DELETE FROM acces WHERE prenom ='"+a.getPrenom()+"' and login = '"+a.getLogin()+"';";
			
			Statement stAddUser = co.createStatement();  
			stAddUser.executeUpdate(strInsert);
			
			close();
			return true;
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public static Acces[] listerDAO() {
		// TODO Auto-generated method stub
		String str = "SELECT prenom, login, statut, age FROM acces;";
		Acces[] tab;
		try{
			open();  
			Statement stLogin = co.createStatement();
			
			ResultSet rsLogin = stLogin.executeQuery(str);
			rsLogin.last(); 
			tab = new Acces[rsLogin.getRow()];
			rsLogin.beforeFirst(); 
			
			Integer i=0;
			
			while(rsLogin.next()) {
				Acces a=new Acces();
				a.setPrenom(rsLogin.getString("prenom"));
				a.setLogin(rsLogin.getString("login"));
				a.setStatut(rsLogin.getString("statut"));
				a.setAge(rsLogin.getInt("age"));
				tab[i]=a;
			}
			close();
			return tab;
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tab=null;
	}

}
