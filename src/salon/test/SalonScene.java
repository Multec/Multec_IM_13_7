/**
 * 
 */
package salon.test;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.font.IFont;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

/**
 * @author Sebastian
 *
 */
public class SalonScene extends AbstractScene {
	private MTApplication mtApp;
	/**
	 * @param mtApplication
	 * @param name
	 */
	public SalonScene(MTApplication mtApplication, String name) {
		super(mtApplication, name);
		this.mtApp = mtApplication;
		MTColor white = new MTColor(255,255,255);
		this.setClearColor(new MTColor(146, 150, 188, 255));
		IFont fontArial = FontManager.getInstance().createFont(mtApplication, "arial.ttf", 
				50, 	//Font size
				white,  //Font fill color
				white);	//Font outline color
		//Create a textfield
		MTTextArea textField = new MTTextArea(mtApplication, fontArial); 
		
		textField.setNoStroke(true);
		textField.setNoFill(true);
		
		textField.setText("Test Salon!");
		//Center the textfield on the screen
		textField.setPositionGlobal(new Vector3D(mtApplication.width/2f, mtApplication.height/2f));
		//Add the textfield to our canvas
		this.getCanvas().addChild(textField);
	}

	/* (non-Javadoc)
	 * @see org.mt4j.sceneManagement.AbstractScene#init()
	 */
	@Override
	public void init() {
		//

	}

	/* (non-Javadoc)
	 * @see org.mt4j.sceneManagement.AbstractScene#shutDown()
	 */
	@Override
	public void shutDown() {
		// 

	}

}
