package com.poly.son.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.son.entity.Account;
import com.poly.son.service.DangNhapService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DangNhapController {
	
	@Autowired
	DangNhapService dangNhapService;
	
	@Autowired
	HttpServletRequest request;

	@GetMapping("/log-in")
	public String viewLogIn(Model model) {
		model.addAttribute("account", new Account());
		return "home/dangNhap";
	}
	
	@PostMapping("/log-in")
	public String signIn(@Validated @ModelAttribute("account") Account form, Model model) {
		Account account = dangNhapService.getByUserName(form.getUserName());
		
		if(account == null) {
			return "home/dangNhap";
		}
		
		if(!account.getPassWord().equalsIgnoreCase(form.getPassWord())) {
			return "home/dangNhap";
		}
		request.getSession().setAttribute("user", account);
		String uri = (String) request.getSession().getAttribute("security-uri");
		if(account.getRoleId().getId() == 1) {
			if(uri != null) {
				return "redirect:" + uri;
			}
			return "redirect:/home";
		} else {
			if(uri != null) {
				return "redirect:" + uri;
			}
			return "redirect:/manager/products";
		}
	}
}
