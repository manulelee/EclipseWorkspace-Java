package com.epicode.models;



public interface Subject {

	public void addReciver(Observer o);
	public void removeReciver(Observer o);
	public void notify(String message);
	
}
