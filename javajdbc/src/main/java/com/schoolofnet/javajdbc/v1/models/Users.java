package com.schoolofnet.javajdbc.v1.models;

public class Users {
	private Integer id;
	private String name;
	
	public Users() {
		this.id = null;
		this.name = null;
	}
	
	public Users(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.id + " - " + this.name;
	}
}
