package com.bitacademy.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/*import org.springframework.web.bind.annotation.RequestParam;*/
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/*어노테이션(@)은 사전적 의미로는 주석이라는 뜻이다.
자바에서 사용될 때의 어노테이션은 코드 사이에 주석처럼 쓰여서 특별한 의미, 기능을 수행하도록 하는 기술이다. 
즉, 프로그램에게 추가적인 정보를 제공해주는 메타데이터(meta data: 데이터를 위한 데이터)
클래스, 메소드, 변수, 파라메터에 붙을 수 있음*/
@Controller
public class HelloController {
	
	// 이게 포워드,dispatcher().forward() 이 녀석역할인듯
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String hello2(/* @RequestParam 생략*/ String name) {// request중 parameter가 name인 애를 찾아서 넣음
		System.out.println("name: " + name);
		return "/WEB-INF/views/hello.jsp";
	}
	//////////////////////////////////////데이터를 JSP에 넘길때(3번4번)////////////////////////////////////////
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {// request중 parameter가 name인 애를 찾아서 넣음
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		
		return mav;
	}
	//추천하는 방법, NEW가 없고 깔끔해 보이는 코드
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {// request중 parameter가 name인 애를 찾아서 넣음
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello3.jsp";
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@ResponseBody // 이게 붙어있으면 return값을 메시지로 인식함, object를 던질수도 있음-> 메시지 컨버터 설정을 바꿔야함 설정 안바꾸면 String을 HTML로 바꿔줌
	@RequestMapping("/hello5")
	public String hello5() {
		return "<h1>Hello World</h1>";
	}
	
	// 리다이렉트, redirect
	@RequestMapping("/hello6")
	public String hello6() {
		return "redirect:/hello";
	}
	
	//안 좋은 코드, servlet기술, HTTP기술을 가져온코드, 스프링 목적에 맞지 않음(비침투성), 스프링이 스마트하게 해주는걸 손으로 하고 있는거임
	@RequestMapping("/hello7")
	public void hello7(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
		String name = request.getParameter("name");
		out.write("hello " + name);
	}
}
