package org.instorm.web.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.instorm.model.User;
import org.instorm.service.LoginService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

public class LoginController {
	
	@Resource
	private LoginService loginService;

	public String login(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password,
			Model model,
			HttpServletRequest request) {
		if (username != null && password != null) {
			User user = loginService.login(username, password);
			if (user != null) {
				model.addAttribute("username", user.getUsername());
				model.addAttribute("password", user.getPassword());
				request.getSession().setAttribute("user", user);
				return "welcome";
			}
			return "login";
		}
		model.addAttribute("errorMessage", "请填写用户名和密码！");
		return "login";
	}
	@RequestMapping(value = "/test")
	ModelAndView test(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = loginService.login(username, password);
		if(user != null){
			try {
				response.getWriter().write(JSON.toJSONString(user));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().write("{\"fail\":\"fail\"}");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
