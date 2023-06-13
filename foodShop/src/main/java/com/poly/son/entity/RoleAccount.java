package com.poly.son.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "role_account")
public class RoleAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name_role")
	private String nameRole;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name = "update_at")
	private LocalDate updateAt;
	
	@OneToMany(mappedBy = "roleId", fetch = FetchType.LAZY)
	private List<Account> listAccount;
}
