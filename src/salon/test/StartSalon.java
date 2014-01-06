/**
 * 
 */
package salon.test;

import org.mt4j.MTApplication;

/**
 * @author Sebastian
 *
 */
public class StartSalon extends MTApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see org.mt4j.MTApplication#startUp()
	 */
	@Override
	public void startUp() {
		addScene(new SalonScene(this, "Salon Test"));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialize();
	}

}
