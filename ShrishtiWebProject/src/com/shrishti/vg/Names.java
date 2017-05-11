package com.shrishti.vg;

public class Names {
	int id;
	String name;
	int count;
	
	public Names() {
	}

	public Names(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Names(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	public Names(int id, String name, int count) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
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
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
}
