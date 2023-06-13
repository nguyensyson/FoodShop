package com.poly.son.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.poly.son.entity.ProductCategory;
import com.poly.son.entity.Products;

public interface HomeService {

	List<ProductCategory> listCategory();
	Page<Products> listProducts(Integer page);
	Page<Products> getByCategory(Integer idCategory, Integer page);
	Products getById(Integer id);
}
