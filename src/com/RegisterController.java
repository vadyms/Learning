package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;

@Controller
public class RegisterController {
	   
	   
	   @RequestMapping(value = "/pages/authorization/register", method = RequestMethod.GET)
	   public ModelAndView user() {
	      return new ModelAndView("/pages/authorization/register", "command", new User());
	   }
	   
	   @RequestMapping(value = "/pages/authorization/addUser", method = RequestMethod.POST)
	   public ModelAndView addUser(@ModelAttribute("SpringWeb")User user, 
			   ModelMap model) {
		      model.addAttribute("name", user.getName());
		      model.addAttribute("password", user.getPassword());
		      model.addAttribute("email", user.getEmail());
		      System.out.println(String.format("User %s was added!", user.getName()));
		      
	      return new ModelAndView("/pages/main", "command", user);
	   }
}