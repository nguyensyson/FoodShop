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
public class Invoice {

	private Integer id;
	private Integer accountId;
	private String nameClient;
	private String sdt;
	private String address;
	private BigDecimal originalBill;
	private BigDecimal actualBill;
	private Integer status;
	private LocalDate createdAt;
	private LocalDate payAt;
}
