package com.poly.son.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.son.dto.ProductCartDTO;
import com.poly.son.service.GioHangService;

@Controller
public class GioHangController {
	
	@Autowired
	GioHangService gioHangService;

	@GetMapping("/gio-hang")
	public String hienThiGioHang(Model model) {
		model.addAttribute("listCart", gioHangService.getCart());
		return "home/gioHang";
	}
	
	@PostMapping("/gio-hang/add/{id}")
	public String add(@PathVariable("id") Integer id, @RequestParam("qty") Integer qty) {
		int temp = 0;
		for (ProductCartDTO i : gioHangService.getCart()) {
			if(i.getId() == id) {
				temp++;
			}
		}
		
		if(temp == 0) {
			gioHangService.add(id);
		} else {
			gioHangService.addMore(id, qty);
		}
		
		return "redirect:/gio-hang";
	}
	
	@GetMapping("/gio-hang/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		gioHangService.remove(id);
		return "redirect:/gio-hang";
	}
	
	@RequestMapping("/gio-hang/update/{id}")
	public String update(@PathVariable("id") Integer id, 
			@RequestParam("qty") Integer qty) {
		if(qty <= 0) {
			gioHangService.remove(id);
		} else {
			ProductCartDTO dto =  gioHangService.update(id, qty);
		}
		
		return "redirect:/gio-hang";
	}
	
	@GetMapping("/cart/clear")
	public String clear(Model model) {
		gioHangService.clear();
		model.addAttribute("message", "Mua hàng thành công");
		model.addAttribute("listCart", gioHangService.getCart());
		return "home/gioHang";
	}
}
