package sammi;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

public class BackgroundManager {

	private MTApplication mtApplication;
	private AbstractScene scene;
	private MTColor bgColor, ellipseColor;
	private ArrayList<HUDElement> HUDElements = new ArrayList<HUDElement>();
	
	public BackgroundManager(MTApplication mtApplication, AbstractScene scene, MTColor bgColor, MTColor ellipseColor) {
		this.mtApplication = mtApplication;
		this.scene = scene;
		this.bgColor = bgColor;
		this.ellipseColor = ellipseColor;
	}
	
	public void drawBackGround() {
		scene.setClearColor(bgColor);
		MTEllipse bgCirkel;
		
		for (int i = 0; i <= mtApplication.width / 16; i++) {
			for (int j = 0; j <= mtApplication.height / 8; j++) {
				double jX = j;
				int v = i * 16;
				int w = j * 8;
				
				if ((jX % 2) == 0) {
					bgCirkel = new MTEllipse(mtApplication, new Vector3D(v, w), 4, 4);
				} else {
					bgCirkel = new MTEllipse(mtApplication, new Vector3D(v + 8, w), 4, 4);
				}
				
				for (HUDElement element : HUDElements) {
					int[][] coordinates = element.getCoordinates();
					
					for (int k = 0; k < coordinates.length; k++) {
						if (coordinates[k][0] == i && coordinates[k][1] == j) {
							bgCirkel.setFillColor(new MTColor(255, 255, 255));
							break;
						}
						else {
							bgCirkel.setFillColor(ellipseColor);
						}
						
					}
				}
				bgCirkel.setNoStroke(true);
				bgCirkel.removeAllGestureEventListeners();
				scene.getCanvas().addChild(bgCirkel);
			}
		}
	}
	
	public void addHUDElement(HUDElement hudElement) {
		HUDElements.add(hudElement);
	}
	
	public void removeHUDElement(int index) {
		HUDElements.remove(index);
	}
}
