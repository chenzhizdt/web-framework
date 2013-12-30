package org.instorm.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.instorm.model.LoveHistory;
import org.instorm.model.ResponseMessage;
import org.instorm.model.User;
import org.instorm.service.CoupleService;
import org.instorm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private CoupleService coupleService;
	
	@RequestMapping(value="/login")
	public ModelAndView login(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			HttpServletResponse response){
		ResponseMessage rm = createResponseMessage(0);
		if (username != null && password != null) {
			User user = userService.login(username, password);
			if(user != null){
				rm.setStatus(ResponseMessage.SUCCESS);
				rm.setMessage("success");
				rm.setItem(user);
				sendResponse(rm, response);
				return null;
			}
		}
		sendResponse(rm, response);
		return null;
	}
	
	@RequestMapping(value="/register")
	public ModelAndView register(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			HttpServletResponse response){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		ResponseMessage rm = createResponseMessage(0);
		if(userService.register(user) == 1){
			rm.setMessage("username exists");
		} else {
			rm.setItem(user);
			rm.setStatus(ResponseMessage.SUCCESS);
			rm.setMessage("success");
		}
		sendResponse(rm, response);
		return null;
	}
	
	@RequestMapping(value="/lovehistory")
	public ModelAndView loveHistory(HttpServletResponse response){
		ResponseMessage rm = createResponseMessage(1);
		rm.setItem(coupleService.getAllLoveHistories());
		sendResponse(rm, response);
		return null;
	}
	
	@RequestMapping(value="/lovehistory/add")
	public ModelAndView addLoveHistory(
			@RequestParam(value = "createname", required = false) String createname,
			@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "userid", required = false) Integer userid,
			HttpServletResponse response){
		User user = userService.getUser(userid);
		LoveHistory loveHistory = new LoveHistory();
		loveHistory.setContent(content);
		loveHistory.setCreateName(createname);
		loveHistory.setCreateTime(new Date());
		loveHistory.setCreateUserId(userid);
		loveHistory.setCoupleId(user.getCoupleId());
		coupleService.addLoveHistory(loveHistory);
		ResponseMessage rm = createResponseMessage(1);
		sendResponse(rm, response);
		return null;
	}
	
	private void sendResponse(ResponseMessage rm, HttpServletResponse response){
		try {
			response.getWriter().write(JSON.toJSONString(rm));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ResponseMessage createResponseMessage(int success){
		ResponseMessage rm = new ResponseMessage();
		if(success == 0){
			rm.setStatus(ResponseMessage.FAIL);
			rm.setMessage("fail");
		} else {
			rm.setStatus(ResponseMessage.SUCCESS);
			rm.setMessage("success");
		}
		return rm;
	}
}
