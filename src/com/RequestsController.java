package com;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestsController {

	String s="";
	
	@RequestMapping(value = "/pages/addInfo" , method = RequestMethod.GET)
	public String request0(Model model) {
		model.addAttribute("context", s);
		return "addInfo";
	}
	
//    @RequestMapping(value = "addInfo", method = RequestMethod.GET)
//    public ModelAndView student() {
//          return new ModelAndView("addInfo", "SpringWeb", new String());
//    }

	@RequestMapping(value = "/pages/addInfo" , method = RequestMethod.POST)
	public String request1(@RequestParam String nome, ModelMap model, HttpServletRequest request) {
		s=s+"<br/>"+nome;
		model.addAttribute("context", s);
		System.out.println(request.getLocalAddr()+": "+nome);
		return "addInfo";
	}
	
	
}
