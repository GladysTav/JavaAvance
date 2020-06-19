package View;

import javax.persistence.*;

@Entity @Table( name = "personne" )


public class Personne {
	@Id @GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id;
	protected String Nom;

	public Personne(String s){
		Nom=s;
	}
	public Personne(){
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}
}
