package View;

import java.util.List;
import View.Personne.*;

import javax.persistence.*;


public class Test0 {

    public static void main(String[] args) throws Exception {
	    System.out.println("CA SEMBLE OK 1");
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("TPPersistancev3");
            entityManager = entityManagerFactory.createEntityManager();
        
            System.out.println( "- Lecture de toutes les Personnes -----------" );
            
            List<Personne> Personnes = entityManager.createQuery( "from Personne", Personne.class )
                                   .getResultList();
            for (Personne Personne : Personnes) {
                System.out.println( Personne );
            }
            
            System.out.println( "- Insertion d'une nouvelle Personne ----------" );
            
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            
            Personne newPersonne = new Personne( "Martin" );
            entityManager.persist( newPersonne );
    
            List<Personne> results = entityManager.createQuery("from Personne", Personne.class).getResultList();
            for( Personne Personne : results) {
                System.out.println( Personne );
            }
    
            System.out.println( "- Modification d'une Personne --------------" );
        
            newPersonne.setNom( "Henry" );
            entityManager.persist( newPersonne );
            
            results = entityManager.createQuery("from Personne", Personne.class).getResultList();
            for( Personne Personne : results) {
                System.out.println( Personne );
            }
    
            System.out.println( "- Suppression d'une Personne ---------------" );
            
            entityManager.remove( newPersonne );
            
            results = entityManager.createQuery("from Personne", Personne.class).getResultList();
            for( Personne Personne : results) {
                System.out.println( Personne );
            }
                    
            trans.commit();
            
        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }
}
