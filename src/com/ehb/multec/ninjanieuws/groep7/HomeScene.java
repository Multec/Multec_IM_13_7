package com.ehb.multec.ninjanieuws.groep7;

import org.mt4j.MTApplication;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;

import com.ehb.multec.ninjanieuws.groep7.background.*;
import com.ehb.multec.ninjanieuws.groep7.userinterface.MainPlayer;
import com.ehb.multec.ninjanieuws.groep7.userinterface.UserControlPanel;
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
		
		// UCP's
		UserControlPanel UCP1 = new UserControlPanel(mtApplication, 
				(UserControlPanelHUDElement)bgManager.selectHUDElement("ucp1"),
				-50, 50 + 44);
		UserControlPanel UCP2 = new UserControlPanel(mtApplication, 
				(UserControlPanelHUDElement)bgManager.selectHUDElement("ucp2"),
				0, 150);
		UserControlPanel UCP3 = new UserControlPanel(mtApplication, 
				(UserControlPanelHUDElement)bgManager.selectHUDElement("ucp3"),
				50, 50 + 44);
		this.getCanvas().addChild(UCP1);
		this.getCanvas().addChild(UCP2);
		this.getCanvas().addChild(UCP3);
		
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
