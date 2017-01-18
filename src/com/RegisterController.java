package com;

import java.util.Map;
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
	   
	   
	   
	   
	   @RequestMapping( value = "/register", method = RequestMethod.GET )
	   public String viewRegistration(Map<String, Object> model) {
	        User userForm = new User();    
	        model.put("userForm", userForm);
	         
	        return "registration";
	   }
	   
	    @RequestMapping( value = "/register", method = RequestMethod.POST )
	    public String processRegistration(@ModelAttribute("userForm") User user,
	            Map<String, Object> model) {
	         
	        // implement your own registration logic here...
	         
	        // for testing purpose:
	        System.out.println("username: " + user.getName());
	        System.out.println("password: " + user.getPassword());
	        System.out.println("email: " + user.getEmail());
	         
	        return "pages/RegistrationSuccess";
	    }
}