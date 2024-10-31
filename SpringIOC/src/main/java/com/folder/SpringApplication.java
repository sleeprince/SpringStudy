package com.folder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.folder.bean.Test1;
import com.folder.bean.Test2;
import com.folder.bean.Test3;

public class SpringApplication {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		
		Test1 t1 = context.getBean(Test1.class);
		System.out.println(t1.test());
		
		Test2 t2 = context.getBean(Test2.class);
		System.out.println(t2.getA());
		System.out.println(t2.getB());
		
		Test3 t3 = context.getBean(Test3.class);
		System.out.println(t3.getA());
		System.out.println(t3.getB());
		
		t1 = (Test1) context.getBean("test1");
		System.out.println(t1.test());
		
		t1 = context.getBean("test1", Test1.class);
		System.out.println(t1.test());
	}
	
}
