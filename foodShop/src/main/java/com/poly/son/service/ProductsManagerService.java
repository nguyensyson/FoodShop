package com.poly.son.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.poly.son.entity.ProductCategory;
import com.poly.son.entity.Products;

public interface ProductsManagerService {

	Page<Products> sortProducts(Sort sort, Integer page);
	List<ProductCategory> getListCategory();
	Products createProduct(Products products);
	Products updateProduct(Products products, Integer id);
	Products deleteProduct(Integer id);
	Products getById(Integer id);
}
