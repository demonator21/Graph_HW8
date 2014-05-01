import java.util.LinkedList;

public class Network {
	private LinkedList<String> cityNames = new LinkedList<String>();

	public Network(LinkedList<String> cityNames) {
		this.cityNames = cityNames;
	}
	
	public LinkedList<String> getCityNames() {
		return this.cityNames;
	}
}
