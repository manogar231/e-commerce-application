package com.map.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.map.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
	
	@Transactional
	@Query(value = "select * from invoice where invoice_status='NOTPAID' " , nativeQuery = true)
	List<Invoice> getallinvoicebystatus();
     

}
