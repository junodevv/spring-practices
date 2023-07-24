package com.bitacademy.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// 1. XML Auto Configuraion(Annotation Configuration)(자동설정)
		// testXMLAutoConfiguraion();
		// 2. XML Explicit Configuration(Bean Configuration)(명시적, 수동설정)
		testXMLExplicitConfiguration();
	}

	private static void testXMLExplicitConfiguration() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("com/bitacademy/container/config/user/applicationContext02.xml");
		
		User user = null;

		// 오류: id 로 가져오기
		// 명시적 빈설정인 경우에는 id를 자동으로 부여하지 않는다.
		// user = (User)ac.getBean("user");
		// System.out.println(user);
		
		// id로 가져오기
		user = (User)ac.getBean("user2"); // user2는 내가 applicationContext02에서 지정한 id
		System.out.println(user);
		
		// name로 가져오기
		user = (User)ac.getBean("usr2"); // usr2는 내가 applicationContext02에서 지정한 name
		System.out.println(user);
		
		// Type으로 빈 가져오기
		// 같은 type의 2개 이상있으면 type으로만 가져오기는 실패
		// 1. id + type
		user = ac.getBean("user2", User.class);
		System.out.println(user);

		// 2. name + type		
		user = ac.getBean("usr2", User.class);
		System.out.println(user);
		
		// 파라미터 1개인 생성자로 생성된 빈 가져오기
		user = ac.getBean("user3", User.class);
		System.out.println(user);
		
		// 파라미터 2개인 생성자로 생성된 빈 가져오기 01(Long, String 순서대로)
		user = ac.getBean("user4", User.class);
		System.out.println(user);
		
		// 파라미터 2개인 생성자로 생성된 빈 가져오기 02(순서 안맞추고 index를 부여)
		user = ac.getBean("user5", User.class);
		System.out.println(user);
		
		// setter를 사용한 빈 가져오기
		user = ac.getBean("user6", User.class);
		System.out.println(user);
		
		// DI된 빈 가져오기
		user = ac.getBean("user7", User.class);
		System.out.println(user);
	}

	private static void testXMLAutoConfiguraion() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("com/bitacademy/container/config/user/applicationContext01.xml");
		
		User user = null;
		
		user = ac.getBean(User.class);
		System.out.println(user);
		
		//Annotation Scan 설정에서는 Bean id가 자동으로 부여된다.
		user = (User) ac.getBean("user");
		System.out.println(user);
		
		
	}

}
