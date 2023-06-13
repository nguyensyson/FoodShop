package com.poly.son.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCartDTO {

	private Integer id;
	private String nameProduct;
	private String image;
	private Integer quantity;
	private Integer quantityRemaining;
	private BigDecimal price;
}
