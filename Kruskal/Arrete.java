

public class Arrete implements Comparable< Arrete >{
	private String A, B;
	private Integer longueur;
	
	public Arrete(String A, String B, int l) {
		this.A = A;
		this.B = B;
		longueur=l;
	}
	
	public Integer getLongueur() {
		return longueur;
	}
	
	public void setLongueur(int i) {
		longueur=i;
	}
	
	public String[] getPoints(){
		return new String[]{A,B};
	}
	
    @Override
    public int compareTo(Arrete o) {
        return this.getLongueur().compareTo(o.getLongueur());
    }
    
    @Override
    public String toString() {
    	return A+" "+B+" : "+longueur;
    }
}
