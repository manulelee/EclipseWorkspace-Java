package com.epicode.models;



public interface Subject {

	public void addSonda(Observer o);
	public void removeSonda(Observer o);
	public void notify(String message);
	
}
