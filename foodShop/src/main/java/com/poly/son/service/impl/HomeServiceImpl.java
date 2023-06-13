package com.poly.son.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poly.son.entity.ProductCategory;
import com.poly.son.entity.Products;
import com.poly.son.repository.ProductCategoryRepository;
import com.poly.son.repository.ProductsRepository;
import com.poly.son.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	ProductCategoryRepository categoryRepository;
	
	@Autowired
	ProductsRepository productsRepository;

	@Override
	public List<ProductCategory> listCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Page<Products> listProducts(Integer page) {
		Pageable pageable = PageRequest.of(page, 12);
		return productsRepository.findAll(pageable);
	}

	@Override
	public Page<Products> getByCategory(Integer idCategory, Integer page) {
		Pageable pageable = PageRequest.of(page, 12);
		return productsRepository.getByCategory(idCategory, pageable);
	}

	@Override
	public Products getById(Integer id) {
		Optional<Products> product = productsRepository.findById(id);
		if(product.isEmpty()) {
			return null;
		}
		return product.get();
	}

}
