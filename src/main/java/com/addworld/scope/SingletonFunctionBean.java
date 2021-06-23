package com.addworld.scope;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonFunctionBean {
	
	@Autowired
	private Function<String, PrototypeBean> beanFactory;
	
	public PrototypeBean getPrototypeInstance(String name) {
		return beanFactory.apply(name);
	}
}
