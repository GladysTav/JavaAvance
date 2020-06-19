package View;

import java.util.Collection;


public class Adresse {

  private int numero;
  private String rue;
  private String ville;

  public Adresse(int n, String r, String v){
	  numero = n;
	  rue=r;
	  ville=v;
  }
  
  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getRue() {
    return rue;
  }

  public void setRue(String rue) {
    this.rue = rue;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

}
