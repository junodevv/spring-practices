package com.bitacademy.container.config.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bitacademy.container.user.User;

@Configuration // 이게 설정 파일이라는 어노테이션을 꼭 달아줘야함
@ComponentScan(basePackages= {"com.bitacademy.container.soundsystem"})
public class CDPlayerConfig {
	
	/* 명시적 설정 */
//	@Bean
//	public User user() {
//		return new User();
//	}
//	
//	@Bean
//	public Friend friend() {
//		return new Friend();
//	}
}
