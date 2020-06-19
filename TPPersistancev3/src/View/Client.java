package View;


public class Client extends Personne {

  private Adresse adresse;

  public Client(String n,Adresse a){
	  this.nom=n;
	  adresse=a;
  }
  
  public Adresse getAdresse() {
    return adresse;
  }

  public void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }

}
