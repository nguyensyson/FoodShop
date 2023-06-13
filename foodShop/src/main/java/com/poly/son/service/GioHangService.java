package com.poly.son.service;

import java.math.BigDecimal;
import java.util.Collection;

import com.poly.son.dto.ProductCartDTO;

public interface GioHangService {

	ProductCartDTO add(Integer id);
	void remove(Integer id);
	ProductCartDTO update(Integer id, int qty);
	void clear();
	Integer getCount();
	BigDecimal getAmount(Collection<ProductCartDTO> collection);
	ProductCartDTO addMore(Integer id, int qty);
	Collection<ProductCartDTO> getCart();
}
