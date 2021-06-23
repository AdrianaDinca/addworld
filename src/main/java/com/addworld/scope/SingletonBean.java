package com.addworld.scope;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonBean {

	@Autowired
	private PrototypeBean prototypeBean;
	
	public SingletonBean() {
		System.out.println("Singleton instance created");
	}
	
	public PrototypeBean getPrototypeBean() {
		System.out.println("Prototype instance created");
		return prototypeBean;
	}
}
