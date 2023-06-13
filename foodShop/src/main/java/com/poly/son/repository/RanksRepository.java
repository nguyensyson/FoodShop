package com.poly.son.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.son.entity.Ranks;

@Repository
public interface RanksRepository extends JpaRepository<Ranks, Integer> {

}
