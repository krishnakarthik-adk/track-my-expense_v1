package com.dsk.trackmyexpense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dsk.trackmyexpense.model.TrackMyExpense;

/**
 * 
 * @author Krishna
 *
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

	@RequestMapping(value = "/thymeleaf", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("trackmyexpense", new TrackMyExpense());
        return "index";
    }
	
	@RequestMapping(value="/thymeleaf", method=RequestMethod.POST)
	public String submitExpense(@ModelAttribute TrackMyExpense trackMyExpense, Model model)
	{
		model.addAttribute("trackmyexpense", trackMyExpense);
		return "result";
	}
}
