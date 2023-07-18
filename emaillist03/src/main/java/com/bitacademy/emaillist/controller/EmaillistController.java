package com.bitacademy.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.emaillist.repository.EmaillistRepository;
import com.bitacademy.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	@Autowired // <-이렇게 해놓으면 new를 해서 값을 넣지 않아도 알아서 스프링이 찾아옴
	// 이게 있어서 null Point Exception도 안뜸, 자동 연결같은 느낌
	private EmaillistRepository emaillistRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		return "/WEB-INF/views/add.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
	
}
