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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "invoice")
public class Invoice {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account accountId;
	
	@Column(name = "name_client")
	private String nameClient;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "original_bill")
	private BigDecimal originalBill;
	
	@Column(name = "actual_bill")
	private BigDecimal actualBill;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name = "pay_at")
	private LocalDate payAt;
	
	@OneToMany(mappedBy = "invoiceId", fetch = FetchType.LAZY)
	private List<InvoiceDetail> invoiceDetail;
}
