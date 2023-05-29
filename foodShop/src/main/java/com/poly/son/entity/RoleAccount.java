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
public class RoleAccount {

	private Integer id;
	private String nameRole;
	private LocalDate createdAt;
	private LocalDate updateAt;
}
