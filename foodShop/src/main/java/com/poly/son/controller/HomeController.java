package com.poly.son.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.son.entity.Products;
import com.poly.son.service.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	HomeService homeService;

	@GetMapping("/home")
	public String hienThi(Model model, @RequestParam Optional<Integer> page) {
		
		model.addAttribute("categoryList", homeService.listCategory());
		model.addAttribute("listProduct", homeService.listProducts(page.orElse(0)));
		model.addAttribute("role", 0);
		return "home/index";
	}
	
	@GetMapping("/home/product")
	public String hienThiBycategory(Model model, @RequestParam Integer id, @RequestParam Optional<Integer> page) {
		model.addAttribute("categoryList", homeService.listCategory());
		model.addAttribute("listProduct", homeService.getByCategory(id, page.orElse(0)));
		model.addAttribute("role", id);
		return "home/index";
	}
	
	@GetMapping("/home/page/{role}")
	public String phanTrang(Model model,@PathVariable Integer role, @RequestParam Optional<Integer> page) {
		model.addAttribute("categoryList", homeService.listCategory());
		if(role == 0) {
			model.addAttribute("listProduct", homeService.listProducts(page.orElse(0)));
		} else {
			model.addAttribute("listProduct", homeService.getByCategory(role, page.orElse(0)));
		}
		model.addAttribute("role", role);
		
		return "home/index";
	}
	
	@GetMapping("/detail/{id}") 
	public String detail(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("categoryList", homeService.listCategory());
		model.addAttribute("productDetail", homeService.getById(id));
		return "home/detail";
	}
	
}
