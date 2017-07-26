package com.gio.model.user;

public class User {
	private int id;
	private String name;
	private String apaterno;
	
	public User(int id, String name, String apaterno){
		this.id = id;
		this.name = name;
		this.apaterno = apaterno;
	}
	
	public User(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	
	
}
