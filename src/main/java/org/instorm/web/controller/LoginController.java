package org.instorm.web.controller;

import javax.annotation.Resource;

import org.instorm.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Resource
	private LoginService loginService;
	
	@RequestMapping(value="/login")
	public String login(@RequestParam(value="username", required=false) String username, @RequestParam(value="password", required=false) String password, Model model){
		if(username != null && password != null){
			loginService.login(username, password);
			model.addAttribute("username", username);
			model.addAttribute("password", password);
			return "welcome";
		}
		model.addAttribute("errorMessage", "请填写用户名和密码！");
		return "login";
	}
}
