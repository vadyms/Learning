package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;

@Controller
public class LoginController {
 
	   @RequestMapping(value = "/pages/authorization/login", method = RequestMethod.GET)
	   public ModelAndView user() {
	      return new ModelAndView("/pages/authorization/login", "command", new User());
	   }
	   
	   @RequestMapping(value = "/pages/authorization/loginUser", method = RequestMethod.POST)
	   public ModelAndView loginUser(@ModelAttribute("SpringWeb")User user, 
			   ModelMap model) {
		      model.addAttribute("name", user.getName());
		      model.addAttribute("password", user.getPassword());
		      System.out.println(String.format("User %s was logged in!", user.getName()));
		      
	      return new ModelAndView("/pages/main", "command", user);
	   }

}