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
	static private int dx, dy;
	private MTColor bgColor, ellipseColor;
	static private ArrayList<HUDElement> HUDElements = new ArrayList<HUDElement>();
	
	public BackgroundManager(MTApplication mtApplication, MTColor bgColor, MTColor ellipseColor) {
		this.mtApplication = mtApplication;
		this.bgColor = bgColor;
		this.ellipseColor = ellipseColor;
	}
	
	public void drawBackGround() {
		scene.setClearColor(bgColor);
		MTEllipse bgCirkel;
		
		for (int i = 0; i <= mtApplication.width / getDx(); i++) {
			for (int j = 0; j <= mtApplication.height / getDy(); j++) {
				double jX = j;
				int v = i * getDx();
				int w = j * getDy();
				
				if ((jX % 2) == 0) {
					bgCirkel = new MTEllipse(mtApplication, new Vector3D(v, w), 4, 4);
				} else {
					bgCirkel = new MTEllipse(mtApplication, new Vector3D(v + getDy(), w), 4, 4);
				}
				bgCirkel.setFillColor(ellipseColor);
				
				for (HUDElement element : HUDElements) {
					int[][] coordinates = element.getCoordinates();
					
					for (int k = 0; k < coordinates.length; k++) {
						if (coordinates[k][0] == i && coordinates[k][1] == j) {
							bgCirkel.setFillColor(element.getElementColor());
							break;
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

	public static int getDx() {
		return dx;
	}

	public static void setDx(int dx) {
		BackgroundManager.dx = dx;
	}

	public static int getDy() {
		return dy;
	}

	public static void setDy(int dy) {
		BackgroundManager.dy = dy;
	}

	public void setScene(AbstractScene scene) {
		this.scene = scene;
	}
}
