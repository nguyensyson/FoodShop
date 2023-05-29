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
public class Account {

	private Integer id;
	private Integer rankId;
	private Integer roleId;
	private String userName;
	private String passWord;
	private String fullName;
	private String sdt;
	private String address;
	private String email;
	private int points;
	private LocalDate createdAt;
	private LocalDate updateAt;
}
