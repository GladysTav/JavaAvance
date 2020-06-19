package View;

import java.util.List;
import View.Personne.*;

import javax.persistence.*;


public class Test0Projet {

    public static void main(String[] args) throws Exception {
	    System.out.println("CA SEMBLE OK 1");
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("TPPersistancev3");
            entityManager = entityManagerFactory.createEntityManager();
        
            System.out.println( "- Lecture de tous les Projet  -----------" );
            
            List<Projet> projets = entityManager.createQuery( "from Projet", Projet.class )
                                   .getResultList();
            for (Projet Projet : projets) {
                System.out.println( Projet );
            }
            
            System.out.println( "- Insertion d'un nouveau Projet ----------" );
            
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();

            Projet newProjet = new Projet( "Martin" );
            entityManager.persist( newProjet );
            Projet newProjet1 = new Projet( "Projet1" );
            entityManager.persist( newProjet1 );
            /*Projet newProjet2 = new Projet( "Projet2" );
            entityManager.persist( newProjet2 );*/

            Personne newPersonne = new Personne( "Martin" );
            entityManager.persist( newPersonne );
            
            newProjet1.setProprio(newPersonne);
    
            List<Projet> results = entityManager.createQuery("from Projet", Projet.class).getResultList();
            for(Projet Projet : results) {
                System.out.println( Projet );
            }
    
            System.out.println( "- Modification d'un Projet --------------" );
        
            newProjet.setNom( "Henry" );
            entityManager.persist( newProjet );
            
            results = entityManager.createQuery("from Projet", Projet.class).getResultList();
            for(Projet Projet : results) {
                System.out.println( Projet );
            }
    
            System.out.println( "- Suppression d'un Projet ---------------" );
            
            entityManager.remove( newProjet );
            
            results = entityManager.createQuery("from Projet", Projet.class).getResultList();
            for(Projet Projet : results) {
                System.out.println( Projet );
            }
                    
            trans.commit();
            
        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }
}
