package com.poly.son.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.son.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

	@Query("SELECT p FROM Products p WHERE p.categoryId.id = :id")
	public Page<Products> getByCategory(@Param("id") Integer id, Pageable pageable);
}
