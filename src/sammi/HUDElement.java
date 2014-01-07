package sammi;

import org.mt4j.util.MTColor;

public class HUDElement {
	private String name;
	private int[][] coordinates;
	private MTColor elementColor;
	
	public HUDElement(int[][] coordinates, MTColor elementColor) {
		this.coordinates = coordinates;
		this.elementColor = elementColor;
	}
	
	public int[][] getCoordinates() {
		return coordinates;
	}
	
	public void translate(int x, int y) {
		for (int i = 0; i < coordinates.length; i++) {
			coordinates[i][0] += x;
			if (y % 2 == 0) {
				coordinates[i][1] += y;
			} else {
				coordinates[i][1] += (y - 1);
			}
		}
	}

	public MTColor getElementColor() {
		return elementColor;
	}

	public void setElementColor(MTColor elementColor) {
		this.elementColor = elementColor;
	}
}
