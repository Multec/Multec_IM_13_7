package com.ehb.multec.ninajnieuws.groep7.eventlisteners;

import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;

public class BasicTabListener implements IGestureEventListener {

	public BasicTabListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean processGestureEvent(MTGestureEvent ge) {
		TapEvent te = (TapEvent)ge;
		if (!te.isTapDown()) {
			System.out.println("Het werkt!");
		}
		return false;
	}

}
