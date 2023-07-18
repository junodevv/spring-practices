package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping
 * 클래스 + 메서드(핸들러) 매핑
 * 강추!
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	
//	@RequestMapping(value="/joinform", method=RequestMethod.GET)
//	public String joinform() {
//		return "/WEB-INF/views/joinform.jsp";
//	}// 나중엔 jsp, Webinf 이런 기술들도 다 사라짐
	
	
	@RequestMapping(value="/join", method=RequestMethod.GET)// value, method는 안써도되는
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST) // POST방식을 쓸수 있는건 form밖에 없음(html에서)
	public String join(UserVo userVo) {
		System.out.println(userVo);
		return "redirect:/";
	}// 이렇게 파라메터로 객체를 받으면 스프링이 알아서 입력된 파라메터들을 가져옴 ex)joinform의 email, name, password등등을 알아서 가져옴
	
	@ResponseBody // <- 이건 안써도됨 교육용임
	@RequestMapping("/logout")
	public String logout() {
		return "UserController.logout()";
	}
	
	/////////////////////////////////////////////////////////////////////////
	////////////////////////////개별파라메터받는법/////////////////////////////////
	/////////////////////////////////////////////////////////////////////////
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		// 만일n이라는 이름의 파라미터가 없으면
		// 400 bad request 에러가 발생한다.
		return "UserController.update(" + name +")";
	}
	// @RequestParam: 파라메터와 변수이름이 같은 경우는 쓰지 않아도된다.
	
	//////////////////파라메터에 값이 없는 경우 처리방법 2가지////////////////////////////
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required=false) String name) {
		return "UserController.update2(" + name +")";
	}
	//@RequestParam(value="n", required=false) => 이렇게 하면 n값이없어도 400오류가 안뜬다. null값이 적용됨
	
	@ResponseBody
	@RequestMapping("/update3")
	public String update3(@RequestParam(value="n", required=true, defaultValue="") String name) {
		return "UserController.update3(" + name +")";
	}
	// @RequestParam(value="n", required=true, defaultValue="") => 이렇게 디폴트값을 설정할수 있다.
	
	////////////////////////////////////////////////////////////////////////////
	
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value="p", required=true, defaultValue = "1") int pageNo) {
		// 원레 파라메터는 항상 String이라서 직접 형변환을 해줘야해는데 스프링은 그걸 해줌 -> 바로 int pageNo로 받음
		return "UserController.list("+ pageNo +")";
	}
	
	/* 레스트풀 * board를 기준으로 생각하래
	 * 
	 * (R)GET: 뭔가 가져올떄, ex)리스트가져올떄-> /board
	 * 		view에 들어갔을때 -> /board?no=10(이건 촌스럽) -> /board/10 
	 * 
	 * (C)POST: 뭔가 추가할떄
	 * 		
	 * (U)PUT: 뭔가 수정할때
	 * 		
	 * 
	 * (D)DELETE: 뭔가 삭제할때
	 */
}
