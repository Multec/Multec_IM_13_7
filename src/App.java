import org.mt4j.MTApplication;

import processing.core.PApplet;


public class App extends MTApplication {

	@Override
	public void startUp() {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args){
		//MTApplication app  = new MTApplication();
			
		PApplet.main(new String[] {
//					   "--present", 
//					   "--exclusive",
			   "--bgcolor=#000000", 
			   "--hide-stop",
			   "org.mt4j.MTApplication"
			   }
			   ); 
		}
		@Override
		public void setup(){
			size(800,600, OPENGL); //TODO REMOVE
			
			smooth();
			hint(ENABLE_OPENGL_2X_SMOOTH );
			smooth();
			noSmooth();
			
			background(0);
			
			//GL gl = Tools3D.getGL(this);
//			 gl.glEnable(GL.GL_MULTISAMPLE);
//		     gl.glEnable(GL.GL_MULTISAMPLE_EXT);
		}
		@Override
		public void draw(){

		}

}
