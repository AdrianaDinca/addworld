package com.addworld.scope;

public class PrototypeBean {

	private String name;
	
	public PrototypeBean() {
		
	}
	
	public PrototypeBean(String name) {
        System.out.println("Prototype instance " + name + " created");
        this.name = name;
	}
}
