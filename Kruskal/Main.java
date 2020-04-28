import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static boolean isCycle(String pa, String pb, List<Arrete> li) {
		//System.out.println(" - "+pa+" "+pb+" ["+li.size()+"]");
		int index =0;
		if(pa==pb) {
			return true;
		}
		if(li.size()<2) {
			return false;
		}
		
		for(Arrete b : li) {
			String ba = b.getPoints()[0];
			String bb = b.getPoints()[1];
			if(pa==ba && pb==bb) {
				return true;
			}
			if(ba == pa) {
				List<Arrete> li2 = new ArrayList<Arrete>(li);
				li2.remove(index);
				if(isCycle(bb,pb, li2)) {
					return true;
				}
			}
			if(bb == pa) {
				List<Arrete> li2 = new ArrayList<Arrete>(li);
				li2.remove(index);
				if(isCycle(ba,pb, li2)) {
					return true;
				}
			}
			index++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		List<Arrete> Graph = new ArrayList<Arrete>();
		Graph.add( new Arrete("A", "B",7));
		Graph.add( new Arrete("A", "D",5));
		Graph.add( new Arrete("D", "B",9));
		Graph.add( new Arrete("B", "C",8));
		Graph.add( new Arrete("D", "E",15));
		Graph.add( new Arrete("B", "E",7));
		Graph.add( new Arrete("D", "F",6));
		Graph.add( new Arrete("F", "E",8));
		Graph.add( new Arrete("F", "G",11));
		Graph.add( new Arrete("C", "E",5));
		Graph.add( new Arrete("E", "G",9));
		
		Collections.sort(Graph);

		List<Arrete> ACM = new ArrayList<Arrete>();
		for(Arrete a : Graph) {
			if(isCycle(a.getPoints()[0], a.getPoints()[1], ACM)==false ){
				ACM.add(a);
			}
		}
		
		System.out.println("\n\nLes arrêtes de l'arbre couvrant minimum sont : ");
		for(Arrete a: ACM) {
			System.out.println("  - " + a.toString());
		}

	}

}
