package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*어노테이션(@)은 사전적 의미로는 주석이라는 뜻이다.
자바에서 사용될 때의 어노테이션은 코드 사이에 주석처럼 쓰여서 특별한 의미, 기능을 수행하도록 하는 기술이다. 
즉, 프로그램에게 추가적인 정보를 제공해주는 메타데이터(meta data: 데이터를 위한 데이터)*/
@Controller
public class HelloController {
	
	// 이게 포워드,dispatcher().forward() 이 녀석역할인듯
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String hello2(String name) {// request중 parameter가 name인 애를 찾아서 넣음
		System.out.println("name: " + name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {// request중 parameter가 name인 애를 찾아서 넣음
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		return mav;
	}
	
}
