package Model;

import java.util.ArrayList;
import java.util.List;

public class Billet {
    private String titre, contenu, auteur;
    private List<Commentaire> commentaires = new ArrayList<Commentaire>();

    public Billet() {
        this.titre = "Rien";
        this.contenu = "Vide";
        this.auteur = "Personne";
    }

    public Billet(String titre, String contenu, String auteur) {
        this.titre = titre;
        this.contenu = contenu;
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }
    
    public Commentaire getCommentaire(int i) {
        return commentaires.get(i);
    }

    public void addCommentaire(Commentaire c) {
        this.commentaires.add(c);
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
    public String toString(){
    	return "Objet Billet : "+titre+" - "+auteur+" - "+contenu;
    }
    public int getNbCommentaires(){
    	return commentaires.size();
    }
}
