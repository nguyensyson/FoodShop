package com.poly.son.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.son.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Query("SELECT a FROM Account a WHERE a.userName LIKE :username")
	public Account getByUsername(@Param("username") String username);
}
