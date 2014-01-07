package com.ehb.multec.ninajnieuws.groep7;


import org.mt4j.MTApplication;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;

import sammi.BackgroundManager;
import sammi.HUDElement;

public class HelloWorldScene extends AbstractScene {
	// Hoeveel pixels er tussen de bolletjes zitten
	private int dx = 16, dy = 8;
	
	private int[][] arrowUp = new int[3][2];
	private int[][] arrowDown = new int[3][2];
	int[][] ucp1 = new int[9][2];
	int[][] ucp2 = new int[9][2];
	int[][] ucp3 = new int[9][2];
	
	private MTColor blue = new MTColor(33, 224, 224);

	public HelloWorldScene(MTApplication mtApplication, String name) {
		super(mtApplication, name);
		int vScreenWidth = (int)(mtApplication.width / dx);
		int wScreenHeight = (int)(mtApplication.height / dy);
		
		arrowUp[0][0] = 0;
		arrowUp[0][1] = 1;

		arrowUp[1][0] = 1;
		arrowUp[1][1] = 0;

		arrowUp[2][0] = 1;
		arrowUp[2][1] = 1;
		
		arrowDown[0][0] = 1;
		arrowDown[0][1] = 2;

		arrowDown[1][0] = 0;
		arrowDown[1][1] = 1;

		arrowDown[2][0] = 1;
		arrowDown[2][1] = 1;
		
		ucp1[0][0] = 1;
		ucp1[0][1] = 0;
		
		ucp1[1][0] = 0;
		ucp1[1][1] = 1;
		
		ucp1[2][0] = 0;
		ucp1[2][1] = 2;
		
		ucp1[3][0] = 0;
		ucp1[3][1] = 3;
		
		ucp1[4][0] = 1;
		ucp1[4][1] = 4;
		
		ucp1[5][0] = 1;
		ucp1[5][1] = 3;
		
		ucp1[6][0] = 2;
		ucp1[6][1] = 2;
		
		ucp1[7][0] = 1;
		ucp1[7][1] = 1;
		
		ucp1[8][0] = 1;
		ucp1[8][1] = 2;
		
		ucp2[0][0] = 1;
		ucp2[0][1] = 0;
		
		ucp2[1][0] = 0;
		ucp2[1][1] = 1;
		
		ucp2[2][0] = 0;
		ucp2[2][1] = 2;
		
		ucp2[3][0] = 0;
		ucp2[3][1] = 3;
		
		ucp2[4][0] = 1;
		ucp2[4][1] = 4;
		
		ucp2[5][0] = 1;
		ucp2[5][1] = 3;
		
		ucp2[6][0] = 2;
		ucp2[6][1] = 2;
		
		ucp2[7][0] = 1;
		ucp2[7][1] = 1;
		
		ucp2[8][0] = 1;
		ucp2[8][1] = 2;
		
		ucp3[0][0] = 1;
		ucp3[0][1] = 0;
		
		ucp3[1][0] = 0;
		ucp3[1][1] = 1;
		
		ucp3[2][0] = 0;
		ucp3[2][1] = 2;
		
		ucp3[3][0] = 0;
		ucp3[3][1] = 3;
		
		ucp3[4][0] = 1;
		ucp3[4][1] = 4;
		
		ucp3[5][0] = 1;
		ucp3[5][1] = 3;
		
		ucp3[6][0] = 2;
		ucp3[6][1] = 2;
		
		ucp3[7][0] = 1;
		ucp3[7][1] = 1;
		
		ucp3[8][0] = 1;
		ucp3[8][1] = 2;
		
		HUDElement arrowUpElement = new HUDElement(arrowUp, blue);
		HUDElement arrowDownElement = new HUDElement(arrowDown, blue);
		HUDElement UCPElement1 = new HUDElement(ucp1, blue);
		HUDElement UCPElement2 = new HUDElement(ucp2, blue);
		HUDElement UCPElement3 = new HUDElement(ucp3, blue);
		
		// Draw background
		BackgroundManager bgManager = new BackgroundManager(mtApplication, this, new MTColor(48, 48, 48, 255), new MTColor(0, 0, 0), dx, dy);
			
		arrowUpElement.translate(vScreenWidth / 2 - 1, 16);
		arrowDownElement.translate(vScreenWidth / 2 - 1, 0);
		UCPElement1.translate(2, wScreenHeight - 4);
		UCPElement2.translate(vScreenWidth / 2 - 1, wScreenHeight - 4);
		UCPElement3.translate(vScreenWidth - 4, wScreenHeight - 4);
		
		bgManager.addHUDElement(arrowUpElement);
		bgManager.addHUDElement(arrowDownElement);
		bgManager.addHUDElement(UCPElement1);
		bgManager.addHUDElement(UCPElement2);
		bgManager.addHUDElement(UCPElement3);
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
