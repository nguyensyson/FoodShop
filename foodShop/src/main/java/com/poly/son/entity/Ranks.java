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
public class Ranks {

	private Integer id;
	private String nameRank;
	private Integer discount;
	private LocalDate createdAt;
	private LocalDate updateAt;
}
