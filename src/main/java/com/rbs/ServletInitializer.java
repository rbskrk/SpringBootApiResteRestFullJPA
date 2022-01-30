package com.rbs;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	
	private Integer x;
	private Integer y;
	private Integer aux;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		
		teste();
		return application.sources(SpringBootApiResteRestFullJpaApplication.class);
	}
	
	private void teste() {
		
		x = 3;
		y=4;
		aux = 4 * 3;
		y = x ;
		x = aux % 5;
		
		System.out.println();
		
	}

	

}
