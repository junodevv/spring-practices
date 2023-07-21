package com.bitacademy.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	// point cut 이름 줄이기: 접근지시자 생략 가능
	@After("execution(com.bitacademy.aoptest.vo.ProductVo com.bitacademy.aoptest.service.ProductService.find(String))")
	public void adviceAfter() {
		System.out.println("--- After Advice ---");
	}
	// point cut 이름 줄이기 2: 패키지 앞 줄이기 *..*(모든 패키지)
	@AfterReturning("execution(* *..*.ProductService.find(String))")
	public void adviceAfterReturning() {
		System.out.println("--- After Returning Advice ---");
	}
	// point cut 이름 줄이기 3: 파라미터 생략
	@AfterThrowing(value="execution(* *..*.ProductService.find(..))", throwing="ex")
	public void adviceAfterThrowing(Throwable ex) {
		System.out.println("--- After Throwing Advice : "+ ex +"---");
	}
	// point cut 이름 줄이기 4: 메소드 줄이기 *(모든 메소드)
	@Around("execution(* *..*.ProductService.*(String))")
	public Object adviceAround(ProceedingJoinPoint pjp) throws Throwable {
		/* before */
		System.out.println("--- Around(before) Advice ---");
		
		/*Point Cut Method 실행, 파라메터변경*/
		//Object[] parameters = {"Camera"};
		//Object result = pjp.proceed(parameters);
		
		/* 원래 파라메터 */
		Object result = pjp.proceed();
		
		
		/* after */
		System.out.println("--- Around(after) Advice ---");
		
		return result;
	}
}
