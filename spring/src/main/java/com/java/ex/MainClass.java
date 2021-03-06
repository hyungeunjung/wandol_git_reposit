package com.java.ex;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources pro = env.getPropertySources();
		
		try{
		pro.addLast(new ResourcePropertySource("classpath:admin.properties"));
		
		System.out.println(env.getProperty("admin.id"));
		System.out.println(env.getProperty("admin.pw"));
		}catch(IOException e){}
		
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection",AdminConnection.class);
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		System.out.println("adimg");System.out.println("2222");
		
		
		
		System.out.println("2222");
		System.out.println("2222");
		System.out.println("2222");
		
		System.out.println("2222");
		System.out.println("2222");
		
		
		gCtx.close();
		ctx.close();
	}
}
