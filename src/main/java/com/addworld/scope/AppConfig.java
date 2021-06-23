package com.addworld.scope;

import java.util.function.Function;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class AppConfig {
	/*@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	//fix the issue with ScopeProxy
	//@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public PrototypeBean prototypeBean() {
		return new PrototypeBean();
	}
	
	@Bean
	public SingletonBean singletonBean() {
		return new SingletonBean();
	}
	*/
	
	@Bean
	public Function<String, PrototypeBean> beanFactory() {
		return name -> prototypeBeanWithParam(name);
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PrototypeBean prototypeBeanWithParam(String name) {
		return new PrototypeBean(name);
	}
	
	@Bean
	public SingletonFunctionBean singletonFunctionBean() {
		return new SingletonFunctionBean();
	}
	
}
