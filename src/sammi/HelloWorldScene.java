package sammi;


import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

public class HelloWorldScene extends AbstractScene {

	public HelloWorldScene(MTApplication mtApplication, String name) {
		super(mtApplication, name);
		this.setClearColor(new MTColor(48, 48, 48, 255));
		
		// Draw background
		for (int i = 0; i <= mtApplication.width; i += 16) {
			for (int j = 0; j <= mtApplication.height; j += 16) {
				MTEllipse bgCirkel = new MTEllipse(mtApplication, new Vector3D(i, j), 4, 4);
				bgCirkel.setFillColor(new MTColor(0, 0, 0));
				bgCirkel.setNoStroke(true);
				bgCirkel.removeAllGestureEventListeners();
				this.getCanvas().addChild(bgCirkel);
			}
		}
		for (int i = 8; i <= mtApplication.width; i += 16) {
			for (int j = 8; j <= mtApplication.height; j += 16) {
				MTEllipse bgCirkel = new MTEllipse(mtApplication, new Vector3D(i, j), 4, 4);
				bgCirkel.setFillColor(new MTColor(0, 0, 0));
				bgCirkel.setNoStroke(true);
				bgCirkel.removeAllGestureEventListeners();
				this.getCanvas().addChild(bgCirkel);
			}
		
		}
		
		this.registerGlobalInputProcessor(new CursorTracer(mtApplication, this));
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub

	}

}
