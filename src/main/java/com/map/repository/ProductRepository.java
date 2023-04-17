package com.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.map.entity.Product;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Modifying
	@Query(value = "update product set status = ?1 where proid = ?2 ", nativeQuery = true)
	Object updateproductStatus(String status, int id);

}
