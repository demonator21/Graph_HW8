import java.util.LinkedList;

public class Graph {
	private LinkedList<Node> nodes;
	
	public Graph(LinkedList<Node> nodes) {
		this.nodes = new LinkedList<Node>();
	}
	
	public LinkedList<Node> getNodes() {
		return this.nodes;
	}
	
	public Node newNode(String newCityName) {
		Node n = new Node(newCityName);
		this.nodes.add(n);
		return n;		
	}
	
	public void addUndirectedEdge(Node from, Node to) {
		from.addEdge(to);
		to.addEdge(from);
	}
	
	public LinkedList<Network> getNetworks() {
		LinkedList<Network> networksList = new LinkedList<Network>(); //linked list of networks
		LinkedList<Node> visited = new LinkedList<Node>(); //linked list of visited
		LinkedList<String> namesList = new LinkedList<String>(); //linked list of names, that is returned from the findRoutes
		LinkedList<String> alreadyInNetwork = new LinkedList<String>();	// linked list of names that are already in the network so then it is not repeated	
		
		for(Node n: this.nodes) {
			if(!alreadyInNetwork.contains(n.getCityName())) {
				namesList = n.findRoutes(visited);
				if (namesList != null) {
					Network nets = new Network(namesList);
					networksList.add(nets);
				}
				alreadyInNetwork.addAll(namesList);
			}			
		}
		return networksList;			
	}
}
