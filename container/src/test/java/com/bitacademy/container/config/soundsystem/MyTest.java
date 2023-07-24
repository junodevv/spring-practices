package com.bitacademy.container.config.soundsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyTest {
	@Test
	public void test01() {
		int i = 10;
		assertTrue(i - 10 <= 0); // 테스트통과조건 ~~여야 테스트가 성공이다. 하는 조건식
	}
	
	@Test
	public void test02() {
		int i = 10;
		assertEquals(10, i);
	}
}
