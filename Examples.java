import java.util.LinkedList;
import tester.Tester;

public class Examples {
	public Examples() {
	}
	
	Graph g;
	LinkedList<Node> nodes = new LinkedList<Node>();
	LinkedList<Node> visited;
	LinkedList<Node> alreadyInNetwork;
	
	//Network 1
	Node bost = new Node("Boston");
	Node worc = new Node("Worcester");
	Node hart = new Node("Hartford");
	
	//Network 2
	Node chic = new Node("Chicago");
	Node denv = new Node("Denver");
	
	//Network 3
	Node phoe = new Node("Phoenix");
	Node hous = new Node("Houston");
	Node tuls = new Node("Tulsa");
	
	public void populate() {
		
		visited = new LinkedList<Node>();
		alreadyInNetwork = new LinkedList<Node>();
		//Add network1
		nodes.add(bost);
		nodes.add(worc);
		nodes.add(hart);
		
		//Add network2
		nodes.add(chic);
		nodes.add(denv);
		
		//Add network3
		//nodes.add(hous);
		//nodes.add(tuls);
		//nodes.add(phoe);
		
		g = new Graph(nodes);
		
		g.addUndirectedEdge(bost, worc);
		g.addUndirectedEdge(bost, hart);
		
		g.addUndirectedEdge(chic, denv);
		
		//g.addUndirectedEdge(hous, tuls);
		//g.addUndirectedEdge(hous, phoe);
	}
	
	public boolean testFindRoutes(Tester t) {
		populate();
		LinkedList<String> test = new LinkedList<String>();	
		test.add("Boston");
		test.add("Worcester");
		test.add("Hartford");
		
		LinkedList<String> test2 = new LinkedList<String>();	
		test2.add("Chicago");
		test2.add("Denver");
		
		return
				t.checkExpect(bost.findRoutes(visited), test) &&
				//t.checkExpect(tuls.findRoutes(new LinkedList<Node>()), test);
				//t.checkExpect(tuls.findRoutes(visited), test) &&
				t.checkExpect(chic.findRoutes(visited), test2);
	}
	
	public boolean testGetNetworks(Tester t) {
		populate();
		LinkedList<String> test = new LinkedList<String>();	
		test.add("Boston");
		test.add("Worcester");
		test.add("Hartford");
		
		LinkedList<String> test2 = new LinkedList<String>();	
		test2.add("Chicago");
		test2.add("Denver");		

		Network northeast = new Network(test);
		Network northwest = new Network(test2);
		LinkedList<Network> N = new LinkedList<Network>();
		N.add(northeast);
		N.add(northwest);	
		
		return 
				t.checkExpect(g.getNetworks(), N);
	}	
}

