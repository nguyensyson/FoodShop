package com.poly.son.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.son.entity.ProductCategory;
import com.poly.son.entity.Products;
import com.poly.son.repository.ProductCategoryRepository;
import com.poly.son.repository.ProductsRepository;
import com.poly.son.service.ProductsManagerService;

@Service
public class ProductsManagerServiceImpl implements ProductsManagerService{
	
	@Autowired
	ProductsRepository productsRepository;
	
	@Autowired
	ProductCategoryRepository categoryRepository;

	@Override
	public Products createProduct(Products products) {
		return productsRepository.save(products);
	}

	@Override
	public Products updateProduct(Products products, Integer id) {
		Optional<Products> p = productsRepository.findById(id);
		if(p.isEmpty()) {
			return null;
		}
		p.get().setCategoryId(products.getCategoryId());
		p.get().setImage(products.getImage());
		p.get().setNameProduct(products.getNameProduct());
		p.get().setPrice(products.getPrice());
		p.get().setQuantity(products.getQuantity());
		if(products.getQuantity() > 0) {
			p.get().setStatus(1);
		} else {
			p.get().setStatus(0);
		}
		
		return productsRepository.save(p.get());
	}

	@Override
	public Products deleteProduct(Integer id) {
		Optional<Products> p = productsRepository.findById(id);
		if(p.isEmpty()) {
			return null;
		}
		productsRepository.delete(p.get());
		return p.get();
	}

	@Override
	public List<ProductCategory> getListCategory() {
		return categoryRepository.findAll();
	}
	
	@Override
	public Products getById(Integer id) {
		Optional<Products> p = productsRepository.findById(id);
		if(p.isEmpty()) {
			return null;
		}
		return p.get();
	}
	
	@Override
	public Page<Products> sortProducts(Sort sort, Integer page) {
			Pageable pageable = PageRequest.of(page, 15, sort);
		return productsRepository.findAll(pageable);
	}

}
