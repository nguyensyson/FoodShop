package com.poly.son.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCategory {

	private Integer id;
	private String title;
	private LocalDate createdAt;
	private LocalDate updateAt;
}
