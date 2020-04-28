package Model;

public class Commentaire {
    private String titre, contenu, auteur;
    
    public Commentaire(String t, String c, String a){
    	titre=t;
    	contenu=c;
    	auteur=a;
    }
    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
