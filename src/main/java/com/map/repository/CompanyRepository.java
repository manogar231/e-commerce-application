package com.map.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.map.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	@Modifying
	@Query(value = "select * from companyinformation where id = ?1 ", nativeQuery = true)
	Optional<Company> findcompanybyid(Integer id);

	Company findByCompanyname(String companyname);

}
