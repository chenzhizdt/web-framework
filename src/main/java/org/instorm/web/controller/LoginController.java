package org.instorm.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.instorm.model.User;
import org.instorm.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Resource
	private LoginService loginService;

	@RequestMapping(value = "/login")
	public String login(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password,
			Model model,
			HttpServletRequest request) {
		if (username != null && password != null) {
			User user = loginService.findById(username);
			if (user != null) {
				model.addAttribute("username", username);
				model.addAttribute("password", password);
				request.getSession().setAttribute("user", user);
				return "welcome";
			}
			return "login";
		}
		model.addAttribute("errorMessage", "请填写用户名和密码！");
		return "login";
	}
}
