package com.poly.son.service.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.poly.son.dto.ProductCartDTO;
import com.poly.son.entity.Products;
import com.poly.son.repository.ProductsRepository;
import com.poly.son.service.GioHangService;

@SessionScope
@Service
public class GioHangServiceImpl implements GioHangService {
	
	@Autowired 
	ProductsRepository productsRepository;
	
	Map<Integer, ProductCartDTO> map = new HashMap<>();

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Integer getCount() {
		return null;
	}

	@Override
	public BigDecimal getAmount(Collection<ProductCartDTO> cartDTOs) {
		
		return null;
	}

	@Override
	public ProductCartDTO add(Integer id) {
		ProductCartDTO productCartDTO = new ProductCartDTO();
		Optional<Products> product = productsRepository.findById(id);
		if(product.isEmpty()) {
			return null;
		}
		productCartDTO.setId(id);
		productCartDTO.setImage(product.get().getImage());
		productCartDTO.setNameProduct(product.get().getNameProduct());
		productCartDTO.setQuantityRemaining(product.get().getQuantity());
		productCartDTO.setPrice(product.get().getPrice());
		productCartDTO.setQuantity(1);
		map.put(id, productCartDTO);
		return productCartDTO;
	}

	@Override
	public void remove(Integer id) {
		map.remove(id);
	}

	@Override
	public ProductCartDTO update(Integer id, int qty) {
		ProductCartDTO productCartDTO = map.get(id);
		productCartDTO.setQuantity(qty);
		return map.replace(id, productCartDTO);
	}

	@Override
	public ProductCartDTO addMore(Integer id, int qty) {
		ProductCartDTO productCartDTO = map.get(id);
		productCartDTO.setQuantity(productCartDTO.getQuantity() + qty);
		return map.replace(id, productCartDTO);
	}

	@Override
	public Collection<ProductCartDTO> getCart() {
		return map.values();
	}
	
	

}
