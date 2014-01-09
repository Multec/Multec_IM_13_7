package com.ehb.multec.nenjanieuws.groep7.featured;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTImage;
import org.mt4j.input.gestureAction.DefaultDragAction;
import org.mt4j.input.gestureAction.InertiaDragAction;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.math.Vector3D;

public class Featured {
	
	private MTApplication mtApplication;
	private AbstractScene scene;
	
	
	public void setScene(AbstractScene scene) {
		this.scene = scene;
	}

	private int startPos, y;
	private String imagePath =  "data" + MTApplication.separator + "images" + MTApplication.separator;

	public Featured(MTApplication mtApplication, int startPos, int y) {
		this.mtApplication = mtApplication;
		this.startPos = startPos;
		this.y = y;
	}
	
	public void drawFSection() {
		ArrayList<String> photoNames = new ArrayList<String>(); 
        
		photoNames.add("1.jpg"); 
        photoNames.add("2.jpg"); 
        photoNames.add("3.jpg"); 
        photoNames.add("4.jpg"); 
        photoNames.add("5.jpg"); 
        photoNames.add("6.jpg"); 
        photoNames.add("7.jpg"); 
        photoNames.add("8.jpg");
        photoNames.add("9.jpg");
        photoNames.add("10.jpg");
        photoNames.add("11.jpg");
        photoNames.add("12.jpg");
        photoNames.add("13.jpg");
        photoNames.add("14.jpg");
        /*photoNames.add("15.jpg");
        photoNames.add("16.jpg");
        photoNames.add("17.jpg");
        photoNames.add("18.jpg");*/
        
        
        float width = 0;
        float height = 0;
        int x = startPos;
        int margin = 0;
        
        
        for(int i = 0; i < photoNames.size(); i++){
        	
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
        	
        	final MTRectangle photoRect = new MTRectangle(mtApplication.loadImage(imagePath + photoNames.get(i)),mtApplication);
        	//final MTImage photoRect = new MTImage(mtApplication.loadImage(imagePath + photoNames.get(i)),mtApplication);
        	
        	
        	if(i == 0) {
        		width = photoRect.getWidthXY(TransformSpace.GLOBAL);
        		height = photoRect.getHeightXY(TransformSpace.GLOBAL);
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
        	
        	photoRect.setWidthLocal(width);
        	photoRect.setHeightLocal(height);
        	photoRect.setPositionGlobal(new Vector3D(x,y,0));
    		//double tap
    		photoRect.registerInputProcessor(new TapProcessor(mtApplication, 25, true, 350));
    		
    		final Vector3D position = photoRect.getCenterPointGlobal();
    		
    		photoRect.addGestureListener(TapProcessor.class, new IGestureEventListener() {
    			public boolean processGestureEvent(MTGestureEvent ge) {
    				TapEvent te = (TapEvent)ge;
    				if (te.isDoubleTap()){
    					if (position != photoRect.getCenterPointGlobal())
    						photoRect.setPositionGlobal(new Vector3D(position));
    				}
    				return false;
    			}
    		});
    		photoRect.setStrokeWeight(0);
        	photoRect.setNoStroke(true);
        	scene.getCanvas().addChild(photoRect);
        	x += width + margin;
        }
	}

}
