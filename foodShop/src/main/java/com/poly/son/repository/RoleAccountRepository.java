package com.poly.son.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.son.entity.RoleAccount;

@Repository
public interface RoleAccountRepository extends JpaRepository<RoleAccount, Integer> {

}
