package com.poly.son.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Products {

	private Integer id;
	private Integer categoryId;
	private String nameProduct;
	private String image;
	private Integer quantity;
	private BigDecimal price;
	private Integer status;
	private LocalDate createdAt;
	private LocalDate updateAT;
}
