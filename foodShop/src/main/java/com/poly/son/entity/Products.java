package com.poly.son.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Products {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private ProductCategory categoryId;
	
	@Column(name = "name_product")
	private String nameProduct;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name = "update_at")
	private LocalDate updateAT;
	
	@OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
	private List<InvoiceDetail> invoiceDetail;
}
