package sammi;

public class HUDElement {
	
	private int[][] coordinates;
	
	public HUDElement(int[][] coordinates) {
		this.coordinates = coordinates;
	}

	public int[][] getCoordinates() {
		return coordinates;
	}
	
	public void changeCoordinates(int[][] newCoordinates) {
		this.coordinates = newCoordinates;
	}
}
