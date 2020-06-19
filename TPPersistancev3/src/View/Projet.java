package View;

import javax.persistence.*;

@Entity @Table( name = "projet" )

public class Projet {
	@Id @GeneratedValue( strategy=GenerationType.IDENTITY )
	  private int id;
	  private String nom;
	  private Personne proprio;

	  public Projet(){
		  
	  }
	  public Projet(String n){
		  nom=n;
	  }
  
  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
  
  public Personne getProprio() {
    return proprio;
  }

  public void setProprio(Personne nom) {
    this.proprio = nom;
  }
}
