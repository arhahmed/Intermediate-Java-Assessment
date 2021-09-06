package com.ram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ram.model.Sieve;

@Controller
public class ControllerModule
{
	@RequestMapping("/")
	public String index()
	{
		return "userInput";
	}

	// This will map to the siever action from the web page
	@RequestMapping(value = "/siever", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Sieve s)
	{
		System.out.println("User from HTML UI = " + s);
		/*
		 * Here you can write the code to save the user information in database
		 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("DisplayPrimes");
		modelAndView.addObject("Siever", s);
		return modelAndView;
	}
}
