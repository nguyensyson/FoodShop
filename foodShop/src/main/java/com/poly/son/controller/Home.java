package com.poly.son.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

	@GetMapping("/home/index")
	public String hienThi() {
		return "home/index";
	}
}
