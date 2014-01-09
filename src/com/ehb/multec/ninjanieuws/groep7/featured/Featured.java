package com.ehb.multec.ninjanieuws.groep7.featured;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.TransformSpace;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.math.Vector3D;
import org.mt4j.util.math.Vertex;

import processing.core.PImage;

import com.ehb.multec.ninjanieuws.groep7.movies.NinjaMovie;
import com.ehb.multec.ninjanieuws.groep7.movies.NinjaThumb;
import com.ehb.multec.ninjanieuws.groep7.xml.Xml_Movie_Reader;

public class Featured extends MTComponent{
	
	private MTApplication mtApplication;
	private AbstractScene scene;
	private ArrayList<String> thumbPaths;
	private ArrayList<String> thumbTitles;

	public void setScene(AbstractScene scene) {
		this.scene = scene;
	}

	private int startPos, y;
	private String imagePath =  "data" + MTApplication.separator + "images" + MTApplication.separator;
	final String moviePath = "data" + MTApplication.separator + "movies" + MTApplication.separator;
	
	public Featured(MTApplication mtApplication, int startPos, int y) {
		super(mtApplication);
		this.mtApplication = mtApplication;
		this.startPos = startPos;
		this.y = y;
		drawFSection();
	}
	
	public void drawFSection() {
		Xml_Movie_Reader movieXmlReader = new Xml_Movie_Reader(mtApplication);
		thumbPaths = movieXmlReader.getNinjaMoviePaths();
        thumbTitles = movieXmlReader.getNinjaMovieTitles();
        
        float width = 0;
        float height = 0;
        int x = startPos;
        int margin = 0;
        
        for(int i = 0; i < thumbPaths.size(); i++){
        	
        	if(x > (400 + startPos) && i < 4){
        		y += height + margin; 
        		x = (int) (startPos + (width*2) - (width/2) + margin); 
        		System.out.println(x);
        	}
        	if(x > (400 + startPos) && i > 4 && i < 8) {
        		y += height + margin;
        		x = (int) (startPos - width + (width/2));
        	}
        	if(x > (100 + startPos) && i > 4 && i < 8) {
        		y += height + margin;
        		x = (int) (startPos - width + (width/2)); 
        	}
        	if(i == 9) {
        		y  = (int) (y - height/2);
        		x = (int) (startPos + width*2 + margin);
        	}
        	if(i > 9 && x > (400 + startPos)) {
        		y += height + margin;
        		x = startPos;
        	}
        	PImage thumb = mtApplication.loadImage(imagePath + thumbPaths.get(i)+".jpg");
        	final NinjaThumb ninjaThumb = new NinjaThumb(thumb, mtApplication);
        	ninjaThumb.setTitle(thumbTitles.get(i));
        	ninjaThumb.setPath(thumbPaths.get(i));
        	//final MTImage photoRect = new MTImage(mtApplication.loadImage(imagePath + photoNames.get(i)),mtApplication);
        	
        	if(i == 0) {
        		width = ninjaThumb.getWidthXY(TransformSpace.GLOBAL);
        		height = ninjaThumb.getHeightXY(TransformSpace.GLOBAL);
        	}
      
        	if(i == 1) {
        		width /= 2;
        		height /= 2;
        		x = (int) (x - width/2);
        		y = (int) (y - height/2);
        	}
        	if(i == 9){
        		width *= 2;
        		height *= 2;
        	}
        	
        	ninjaThumb.setWidthLocal(width);
        	ninjaThumb.setHeightLocal(height);
        	ninjaThumb.setPositionGlobal(new Vector3D(x,y,0));
    		//double tap
        	ninjaThumb.registerInputProcessor(new TapProcessor(mtApplication, 25, true, 350));
    		
    		final Vector3D position = ninjaThumb.getCenterPointGlobal();
    		
    		ninjaThumb.addGestureListener(TapProcessor.class, new IGestureEventListener() {
    			public boolean processGestureEvent(MTGestureEvent ge) {
    				TapEvent te = (TapEvent)ge;
    				if (te.isDoubleTap()){
    					if (position != ninjaThumb.getCenterPointGlobal())
    						ninjaThumb.setPositionGlobal(new Vector3D(position));
    				}
    				if(te.isTapped()){
    					NinjaMovie ninjaMovie = new NinjaMovie(moviePath+ninjaThumb.getPath()+".mp4", new Vertex(position.x, position.y), mtApplication);
    					scene.getCanvas().addChild(ninjaMovie);
    				}
    				return false;
    			}
    		});
    		
    		
    		ninjaThumb.setStrokeWeight(0);
    		ninjaThumb.setNoStroke(true);
        	this.addChild(ninjaThumb);
        	x += width + margin;
        }
	}

}
