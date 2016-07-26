package com.slick.cleaner.model;

public class Drawable extends Resource {

	private static final String DRAWABLE_ACCESS_CLASS_NAME = "drawable";
	
	public Drawable() {
		super();
	}
	
	@Override
	protected String getResourceAccessClass() {
		return DRAWABLE_ACCESS_CLASS_NAME;
	}
	
	
}
