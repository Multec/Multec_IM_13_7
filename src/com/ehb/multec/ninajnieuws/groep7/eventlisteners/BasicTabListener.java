package com.ehb.multec.ninajnieuws.groep7.eventlisteners;

import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;

public class BasicTabListener implements IGestureEventListener {

	public BasicTabListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean processGestureEvent(MTGestureEvent arg0) {
		System.out.println("Het WERKT!");
		return true;
	}

}
