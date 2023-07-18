package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping
 * 메서드(핸들러) 단독 매핑
 * 
 */
@Controller
public class BoardController {
	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return "BoardController.write()";
	}
	@ResponseBody
	@RequestMapping("/board/view")
	public String view() {
		return "BoardController.view()";
	}
	//////////////////////////////////////////////////
	// 메서드 단독매핑은 이렇게 반복되는 느김이듦 -> UserController 가서 좋은 예시를 보시오
	
	
	////////////////////깔끔하게 파라메터 받는법 (POST)///////////////////////
	@ResponseBody
	@RequestMapping("/board/{no}")	// {변수가 들어올 자리다} 라는 표시,
	//이름이 변수 Long no 와는 달라도되지만, 파라메터이름 "no"와는 이름이 같아야함 
	public String view2(@PathVariable("no") Long no) {
		return "BoardController.view("+ no +")";
	///////////////////////////////////////////////////////////////////
	}
}
