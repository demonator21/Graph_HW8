import java.util.LinkedList;

public class Node {
	private String cityName;
	private LinkedList<Node> getsTo;
	
	public Node(String cityName) {
		this.cityName = cityName;
		this.getsTo = new LinkedList<Node>();	
	}
		
	public String getCityName() {
		return this.cityName;
	}
	
	public LinkedList<Node> getGetsTo() {
		return this.getsTo;
	}
	
	public void addEdge(Node to) {
		if(!this.getsTo.contains(to)) {
			this.getsTo.add(to);
		}
	}
	
	public LinkedList<String> findRoutes(LinkedList<Node> visited) {
		LinkedList<String> namesOfCity = new LinkedList<String>();
				
		if(visited.contains(this)) { //if it has been visited
			return new LinkedList<String>();
		}
		else {
			namesOfCity.add(this.getCityName());
			visited.add(this);
			for(Node n: this.getsTo) {
				if(! visited.contains(n))
					namesOfCity.addAll(n.findRoutes(visited));				
			}
		}
		return namesOfCity;
	}
}