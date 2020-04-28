package Model;

public class Acces {
	Integer id;
	String prenom;
	String login;
	String password;
	String statut;
	Integer age;

	public void setId(int i){
		id=i;
	}
	public void setPrenom(String i){
		prenom=i;
	}
	public void setLogin(String i){
		login=i;
	}
	public void setPassword(String i){
		password=i;
	}
	public void setStatut(String i){
		statut=i;
	}
	public void setAge(int i){
		age=i;
	}

	public Integer getId(){
		return id;
	}
	public String getPrenom(){
		return prenom;
	}
	public String getLogin(){
		return login;
	}
	public String getPassword(){
		return password;
	}
	public String getStatut(){
		return statut;
	}
	public Integer getAge(){
		return age;
	}

}
