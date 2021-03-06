package com.ehb.multec.ninjanieuws.groep7;

import org.mt4j.MTApplication;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;

import com.ehb.multec.ninjanieuws.groep7.background.*;
import com.ehb.multec.ninjanieuws.groep7.featured.Featured;
import com.ehb.multec.ninjanieuws.groep7.organic.Organic;
import com.ehb.multec.ninjanieuws.groep7.userinterface.MainPlayer;
import com.ehb.multec.ninjanieuws.groep7.xml.*;

public class HomeScene extends AbstractScene {
	// Hoeveel pixels er tussen de bolletjes zitten in de achtergrond
	private int dx = 16, dy = 8;

	public HomeScene(MTApplication mtApplication, String name, BackgroundManager bgManager) {
		super(mtApplication, name);
		mtApplication.noStroke();
		int vScreenWidth = (int)(mtApplication.width / dx);
		int wScreenHeight = (int)(mtApplication.height / dy);
		Xml_HUDElement_Reader HUDElementsReader = new Xml_HUDElement_Reader(mtApplication);
		
		// BACKGROUND
		bgManager.setScene(this);
		BackgroundManager.setDx(dx);
		BackgroundManager.setDy(dy);
		bgManager.setHUDElements(HUDElementsReader.getHUDElements());
		bgManager.selectHUDElement("ucp");
		
		bgManager.selectHUDElement("arrowUp").translate(vScreenWidth / 2 - 1, 16);
		bgManager.selectHUDElement("arrowDown").translate(vScreenWidth / 2 - 1, 0);
		bgManager.selectHUDElement("ucp1").translate(2, wScreenHeight - 4);
		bgManager.selectHUDElement("ucp2").translate(vScreenWidth / 2 - 1, wScreenHeight - 4);
		bgManager.selectHUDElement("ucp3").translate(vScreenWidth - 4, wScreenHeight - 4);
		
		bgManager.drawBackGround();
		
		// MAIN PLAYER
		MainPlayer playlist = new MainPlayer(mtApplication, this);
		playlist.drawBackground();
		
		// FEATURED
		Featured featured = new Featured(mtApplication, 250, 250);
		featured.setScene(this);
		this.getCanvas().addChild(featured);
				
		// ORGANIC
		Organic organic = new Organic(mtApplication, this);
		this.getCanvas().addChild(organic);
		
		// USER CONTROL PANEL
		UserControlPanelHUDElement ucp1 = (UserControlPanelHUDElement) bgManager.selectHUDElement("ucp1");
		this.getCanvas().addChild(ucp1.getUCP());
		this.getCanvas().addChild(ucp1.getUCP().getTouchArea());
		UserControlPanelHUDElement ucp2 = (UserControlPanelHUDElement) bgManager.selectHUDElement("ucp2");
		this.getCanvas().addChild(ucp2.getUCP());
		this.getCanvas().addChild(ucp2.getUCP().getTouchArea());
		UserControlPanelHUDElement ucp3 = (UserControlPanelHUDElement) bgManager.selectHUDElement("ucp3");
		this.getCanvas().addChild(ucp3.getUCP());
		this.getCanvas().addChild(ucp3.getUCP().getTouchArea());
		

		
		this.registerGlobalInputProcessor(new CursorTracer(mtApplication, this));
	}

	@Override
	public void init() {
	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub

	}

}
