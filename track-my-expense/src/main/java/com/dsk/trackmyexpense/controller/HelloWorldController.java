package com.dsk.trackmyexpense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Krishna
 *
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap modelMap)
	{
		modelMap.addAttribute("greeting", "Spring 4.3 MVC");
		return "welcome";
	}
	
	@RequestMapping(value="/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap modelMap)
	{
		modelMap.addAttribute("greeting", "Hello from Spring 4.3 MVC");
		return "welcome";
	}
	
	@RequestMapping(value = "/thymeleaf", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("recipient", "World");
        return "index";
    }
}
