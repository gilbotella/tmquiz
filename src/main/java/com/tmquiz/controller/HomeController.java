package com.tmquiz.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * A new game is created.
 */
@Controller
@SessionAttributes("quiz")
class HomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() throws IOException {
		return "home";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() throws IOException {
		return "about";
	}
}
