package com.dsk.trackmyexpense.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dsk.trackmyexpense.model.TrackMyExpense;
import com.dsk.trackmyexpense.service.ITrackMyExpenseService;
import com.dsk.trackmyexpense.utils.TrackMyExpenseUtils;

/**
 * 
 * @author Krishna
 *
 */
@Controller
@SessionAttributes({"itemCategories", "paymentOptions"})
@RequestMapping("/")
public class HelloWorldController {

	private static final Logger LOGGER = LogManager.getLogger(HelloWorldController.class);
	
	@Autowired(required=true)
	private ITrackMyExpenseService expenseService;
	
	@ModelAttribute("itemCategories")
	public List<String> populateItemCategories()
	{
		return TrackMyExpenseUtils.populateItemCategories();
	}
	
	@ModelAttribute("paymentOptions")
	public List<String> populatePaymentOptions()
	{
		return TrackMyExpenseUtils.populatePaymentOptions();
	}
	
	@RequestMapping(value = "/thymeleaf", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("trackmyexpense", new TrackMyExpense());
        LOGGER.info("Action received: /thymeleaf, displaying home page");
        return "index";
    }
	
	@RequestMapping(value="/thymeleaf", method=RequestMethod.POST)
	public String submitExpense(@ModelAttribute TrackMyExpense trackMyExpense, Model model)
	{
		LOGGER.info("Action received: /thymeleaf, submitExpense()");
		
		model.addAttribute("trackmyexpense", trackMyExpense);
		
		expenseService.submitExpenses(trackMyExpense);
		return "result";
	}
}
