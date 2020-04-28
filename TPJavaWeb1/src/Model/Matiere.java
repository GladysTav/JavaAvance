package Model;

public class Matiere {
	private String Nom;
	private Integer Heures;
	
	public Matiere(String n, Integer h){
		Nom=n;
		Heures=h;
	}

	public String getNom() {
	    return Nom;
	  }

	public void setNom(String newName) {
	    this.Nom = newName;
	  }
	
	public Integer getHeures() {
	    return Heures;
	  }

	public void setHeures(String newHeures) {
	    this.Heures = Integer.getInteger(newHeures);
	  }
	
	public String toString(){
		return "Matiere : "+Nom+", nombre d'heures : "+Integer.toString(Heures);
	}
}
