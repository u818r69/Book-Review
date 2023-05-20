package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



 
@Controller
@RequestMapping("/")
public class BookReviewController {

	 
	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}
}
	