package com.ehb.multec.ninjanieuws.groep7;

import org.mt4j.MTApplication;
import org.mt4j.util.MTColor;

import com.ehb.multec.ninjanieuws.groep7.background.*;

public class StartNinjaNieuws extends MTApplication {
	private BackgroundManager bgManager = new BackgroundManager(this, new MTColor(48, 48, 48, 255), new MTColor(0, 0, 0));
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialize();
	}

	@Override
	public void startUp() {
		addScene(new HomeScene(this, "Home", bgManager));
	}

}
