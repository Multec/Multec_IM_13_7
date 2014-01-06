import org.mt4j.MTApplication;

public class Main extends MTApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main() {
		initialize();
	}

	@Override
	public void startUp() {
		// TODO Auto-generated method stub
		addScene(new TestScene(this, "Test Scene"));
	}

}
