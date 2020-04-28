package Model;

import java.util.ArrayList;
import java.util.List;


public class GestionBillets {
    private static List<Billet> billets;
    
    public GestionBillets() {
        billets = new ArrayList<Billet>();
    }

    public static void add(Billet billet) {
        billets.add(billet);
    }

    public static Billet getBillet(int i) {
        return billets.get(i);
    }
    public static Billet getBillet(String a, String t, String c){
    	//System.out.println("a : "+a+" t : "+t+" c : "+c);
    	for(int i=0; i<GestionBillets.getNbBillets();i++){
    		//System.out.println(getBillet(i).getTitre()+" - "+t);
    		if(getBillet(i).getAuteur().equals(a)
    				&& getBillet(i).getTitre().equals(t)
    				&& getBillet(i).getContenu().equals(c)){
    			return getBillet(i);
    		}
    	}
    	return null;
    }

    public static Billet getLastBillet() {
        if (billets.size() > 0)
            return getBillet(billets.size() -1);
        throw new IndexOutOfBoundsException("Erreur dans l'appel à la fonction getLastBillet");
    }
    
    public static int getNbBillets(){
    	return billets.size();
    }
    
    public static List<Billet> getBillets(){
    	return billets;
    }
}
