package com.poly.son.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceDetail {

	private Integer id;
	private Integer invoiceId;
	private Integer productId;
	private String nameProduct;
	private Integer quantity;
	private BigDecimal price;
	private BigDecimal totalPrice;
	private LocalDate createdAt;
	private LocalDate updateAt;
}
