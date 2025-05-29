package com.example.springEducation;

import com.fasterxml.jackson.databind.introspect.Annotated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringEducationApplication {

	public static void main(String[] args) {
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml"
		);
		SmartBean test = context.getBean("student", SmartBean.class);
		System.out.println(test);*/

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		weaponShower shower = context.getBean("weaponShower", weaponShower.class);
		shower.show();
		context.close();
		//SpringApplication.run(SpringEducationApplication.class, args);
	}
}
