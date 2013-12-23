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
		
		// Draw background
		BackgroundManager bgManager = new BackgroundManager(mtApplication, this, new MTColor(48, 48, 48, 255), new MTColor(0, 0, 0));
		int[][] arrow = new int[6][2];
		arrow[0][0] = 2;
		arrow[0][1] = 2;
		
		arrow[1][0] = 1;
		arrow[1][1] = 1;
		
		arrow[2][0] = 1;
		arrow[2][1] = 2;
		
		arrow[3][0] = 0;
		arrow[3][1] = 3;
		
		arrow[4][0] = 2;
		arrow[4][1] = 3;
		
		arrow[5][0] = 1;
		arrow[5][1] = 3;
		
		bgManager.addHUDElement(new HUDElement(arrow));
		bgManager.drawBackGround();
		
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
