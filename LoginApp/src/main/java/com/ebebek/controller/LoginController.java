package com.ebebek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebebek.dao.UserDao;
import com.ebebek.model.User;
import com.ebebek.validator.UserValidator;

@Controller
public class LoginController {
	@Autowired
	private UserDao userDao;

	@Autowired
	private UserValidator userValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	@RequestMapping(value = { "/", "/login" }, method = { RequestMethod.GET })
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "/register" }, method = { RequestMethod.GET })
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}

	@RequestMapping(value = { "/registerProcess" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String registerProcess(@ModelAttribute("user") @Validated User user, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/register";
		}
		userDao.saveUser(user);
		return "redirect:/registerSuccess";
	}

	@RequestMapping(value = { "/registerSuccess" }, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView registerSuccess() {
		ModelAndView mav = new ModelAndView("registerSuccess");
		mav.addObject("message", "New user created successfully");
		return mav;
	}

	@RequestMapping(value = { "/secured/profile" }, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView profile() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("secured/profile");
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userDao.findUserByUsername(username);
		mav.addObject("user", user);
		return mav;
	}
}
