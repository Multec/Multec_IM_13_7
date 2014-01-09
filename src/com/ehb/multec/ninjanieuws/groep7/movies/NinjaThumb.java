package com.ehb.multec.ninjanieuws.groep7.movies;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;

import processing.core.PApplet;
import processing.core.PImage;

public class NinjaThumb extends MTRectangle {
	private String path;
	private String title;
	public NinjaThumb(PImage texture, PApplet pApplet) {
		super(texture, pApplet);
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}
