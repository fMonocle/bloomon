package com.bloomon.model;

public class Flower {
	private String identifier; // A - Z
	private String size; // L S
	
	
	
	public Flower(String flowerString) {
		identifier = flowerString.substring(0,1);
		size = flowerString.substring(1,2);
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
}
