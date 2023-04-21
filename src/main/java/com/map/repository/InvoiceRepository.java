package com.map.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.map.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
	
	@Modifying
	@Query(value = "select * from invoice where status='notpaid' " , nativeQuery = true)
	List<Invoice> getallinvoicebystatus();
     

}
