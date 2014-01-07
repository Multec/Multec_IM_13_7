package com.ehb.multec.ninajnieuws.groep7.background;

import java.util.ArrayList;
import org.mt4j.util.MTColor;

public class HUDElement {
	private String name;
	private ArrayList<int[]> coordinates = new ArrayList<int[]>();
	private MTColor elementColor;
	
	public HUDElement(MTColor elementColor, String name) {
		this.name = name;
		this.elementColor = elementColor;
	}
	
	public void translate(int x, int y) {
		for (int i = 0; i < coordinates.size(); i++) {
			int[] tempHUDElement = coordinates.get(i);
			tempHUDElement[0] += x;
			if (y % 2 == 0) {
				tempHUDElement[1] += y;
			} else {
				tempHUDElement[1] += (y - 1);
			}
		}
	}

	public String getName() {
		return name;
	}

	public MTColor getElementColor() {
		return elementColor;
	}

	public void setElementColor(MTColor elementColor) {
		this.elementColor = elementColor;
	}
	
	public ArrayList<int[]> getCoordinates() {
		return coordinates;
	}
	
	public void addCoordinate(int[] coordinate) {
		coordinates.add(coordinate);
	}	
}
