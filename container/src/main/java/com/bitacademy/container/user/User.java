package com.bitacademy.container.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
	private Long no = 0L;
	private String name = "둘리";
	
	@Autowired
	private Friend friend;
	
	public User() {}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(Long no, String name) {
		this.name = name;
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + "]";
	}
}
