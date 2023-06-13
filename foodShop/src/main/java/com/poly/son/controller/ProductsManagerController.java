package com.poly.son.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.son.FileUploadUtil;
import com.poly.son.entity.Products;
import com.poly.son.service.ProductsManagerService;

@Controller
public class ProductsManagerController {
	
	@Autowired
	ProductsManagerService managerService;

	@GetMapping("/manager/products")
	public String hienThi(Model model, @RequestParam Optional<Integer> page) {
		model.addAttribute("product", new Products());
		model.addAttribute("listProducts", managerService.sortProducts(Sort.by("id").ascending(), 0));
		model.addAttribute("field", "id");
		model.addAttribute("type", "asc");
		model.addAttribute("listCategory", managerService.getListCategory());
		return "manager/products";
	}
	
	@GetMapping("/manager/products/page/{field}/{type}")
	public String phanTrang(Model model, @PathVariable(name = "field") Optional<String> field,
			@PathVariable(name = "type") String type,
			@RequestParam Optional<Integer> page) {
		model.addAttribute("product", new Products());
		if(type.equals("asc")) {
			model.addAttribute("listProducts", managerService.sortProducts(Sort.by(field.orElse("id")).ascending(), page.orElse(0)));
		} else {
			model.addAttribute("listProducts", managerService.sortProducts(Sort.by(field.orElse("id")).descending(), page.orElse(0)));
		}
		model.addAttribute("listCategory", managerService.getListCategory());
		model.addAttribute("field", field.orElse("id"));
		model.addAttribute("type", type);
		return "manager/products";
	}
	
	@GetMapping("/manager/products/{field}")
	public String sortProduct(Model model, 
			@PathVariable Optional<String> field, 
			@RequestParam String type) {
		model.addAttribute("product", new Products());
		model.addAttribute("listCategory", managerService.getListCategory());
		if(type.equals("asc")) {
			model.addAttribute("listProducts", managerService.sortProducts(Sort.by(field.orElse("id")).ascending(), 0));
		} else {
			model.addAttribute("listProducts", managerService.sortProducts(Sort.by(field.orElse("id")).descending(), 0));
		}
		
		model.addAttribute("field", field.orElse("id"));
		model.addAttribute("type", type);
		
		return "manager/products";
	}
	
	@PostMapping("/manager/products/create")
	public String createProduct(Model model, 
			@Validated @ModelAttribute("product") Products form,
			@RequestParam("file") MultipartFile multipartFile) throws IOException {
		
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			String uploadDir = "uploads/";
			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
			
			form.setImage(fileName);
			if(managerService.createProduct(form) == null) {
				return null;
			}
			
			return "redirect:/manager/products";
		
		
	}
	
	@PostMapping("/manager/products/update")
	public String updateProduct(Model model, 
			@Validated @ModelAttribute("product") Products form,
			@RequestParam Integer id,
			@RequestParam("file") MultipartFile multipartFile) throws IOException {
		
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String uploadDir = "uploads/";
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		
		form.setImage(fileName);
		if(managerService.updateProduct(form, id) == null) {
			return null;
		}
		
		
		return "redirect:/manager/products";
		
	}
	
	@GetMapping("/manager/products/delete")
	public String deleteProduct(Model model, @RequestParam Integer id) {
		if(managerService.deleteProduct(id) == null) {
			return null;
		}
		return "redirect:/manager/products";
	}
	
	@GetMapping("/manager/products/edit")
	public String editProduct(Model model, @RequestParam Integer id, @RequestParam Optional<Integer> page) {
		Products products = managerService.getById(id);
		if(products == null) {
			return null;
		}
		
		
		model.addAttribute("fileEdit", products.getImage());
		model.addAttribute("idEdit", products.getId());
		model.addAttribute("product", products);
		model.addAttribute("listProducts", managerService.sortProducts(Sort.by("id").ascending(), 0));
		model.addAttribute("field", "id");
		model.addAttribute("type", "asc");
		model.addAttribute("listCategory", managerService.getListCategory());
		return "manager/products";
	}
}
