package test;
public class MaClasse {
	
	public static int[] tableauDeTrois(int size){
		int[] tab=new int[size];
		for(int i =1; i<=size;i++) {
			tab[i-1]=3*i;
		}
		return tab;
	}
	
	public static int[] tableauAleatoire(int size){
		int[] tab=new int[size];
		for(int i =0; i<size;i++) {
			tab[i]=(int)(Math.random()*99);
		}
		return tab;
	}
	
	public static void afficherTableau(int[] tab) {
		for(int i=0; i<tab.length; i++) {
			System.out.println(tab[i]);
		}
	}
	
	public static int rechercheMinimum(int[] tab) {
		int min=tab[0];
		for(int i=1; i<tab.length; i++) {
			if(tab[i]<min) {
				min=tab[i];
			}
		}
		return min;
	}
	
	public static int[] triSelection(int[] tab) {
		/*rechercher le plus petit élément du tableau, et l'échanger avec l'élément d'indice 0 ;
		  rechercher le second plus petit élément du tableau, et l'échanger avec l'élément d'indice 1 ;
		  continuer de cette façon jusqu'à ce que le tableau soit entièrement trié.*/
		int min;
		int s;
		for(int a=0;a< tab.length; a++) {//chaque indice du tableau
			min=a;
			for(int b=a; b<tab.length;b++) {
				if(tab[b]<tab[min]) {
					min=b;
				}
			}
			s=tab[min];
			tab[min]=tab[a];
			tab[a]=s;
		}
		return tab;
	}
	
	public static boolean rechercheSequentielle(int[] tab, int val) {
		for(int i=0;i<tab.length;i++) {
			if(tab[i]==val) {
				return true;
			}
		}
		return false;
	}
	public static int[] sousTableau(int tab[],int deb, int fin) {
		int[] rep=new int[fin-deb];
		int a=0;
		for(int i=deb;i<fin;i++) {
			rep[a]=tab[i];
			a++;
		}
		return rep;
	}
	public static boolean rechercheDichotomique(int[] tab, int val) {
		int mid=(tab.length)/2;
		if(tab.length==1) {
			if(tab[0]==val) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(tab[mid]==val) {
			return true;
		}
		else if(tab[mid]<val) {
			//System.out.println(tab[mid]+"<"+val);
			if(rechercheDichotomique(sousTableau(tab,mid,tab.length),val)) {
				return true;
			}
		}
		else if(tab[mid]>val) {
			//System.out.println(tab[mid]+">"+val);
			if(rechercheDichotomique(sousTableau(tab,0,mid),val)){
				return true;
			}
		}
		return false;
	}
	public static boolean rechercheDichotomique2(int[] tab, int val,int deb, int fin) {
		int mid=deb+((fin-deb)/2);
		if(fin==deb || fin==deb+1) {
			if(tab[0]==val) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(tab[mid]==val) {
			return true;
		}
		else if(tab[mid]<val) {
			//System.out.println(tab[mid]+"<"+val);
			if(rechercheDichotomique2(tab,val,mid,fin)) {
				return true;
			}
		}
		else if(tab[mid]>val) {
			//System.out.println(tab[mid]+">"+val);
			if(rechercheDichotomique2(tab,val,deb,mid)){
				return true;
			}
		}
		return false;
	}
		
	public static void main(String[] args) {
		int[] tableau = new int[5];
		/*tableau=tableauDeTrois(5);
		System.out.println("Tableau 1 :");
		afficherTableau(tableau);
		tableau = tableauAleatoire(5);
		System.out.println(" ");
		System.out.println("Tableau 2 :");
		afficherTableau(tableau);
		System.out.println(" ");
		System.out.println("Trié :");
		tableau=triSelection(tableau);
		afficherTableau(tableau);
		System.out.println(" ");*/
		tableau=tableauDeTrois(500);
		//afficherTableau(tableau);
		System.out.println("Recherche dicho2 :");
		System.out.println(rechercheDichotomique2(tableau,1034,0,tableau.length-1));
		
	}
}
