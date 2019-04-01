package com.casdemo.springsecurity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 */
@RestController
public class UserController {

	@RequestMapping("/findLoginUser")
	public void findLoginUser(){
		System.out.println("进入findLoginUser方法");
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(name);
	}
}
