package com.bitacademy.aoptest.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//aspect, AOP를 설정하려면 라이브러리에 추가
@Component
@Aspect
public class MyAspect {
	// point cut 기술방법: (접근지시자 리턴타입 패키지.클래스.메소드(파라미터) throws XXException)
	@Before("execution(public com.bitacademy.aoptest.vo.ProductVo com.bitacademy.aoptest.service.ProductService.find(String))")
	public void adviceBefore() {
		System.out.println("--- Before Advice ---");
	}
	
}
