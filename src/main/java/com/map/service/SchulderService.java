package com.map.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.map.entity.Invoice;
import com.map.repository.InvoiceRepository;
                                                
@Service
public class SchulderService {
   @Autowired
	private InvoiceRepository invoiceRepository;
   
   @Scheduled(fixedDelay =100)
	public void generateinvoice() {
	   
    	List<Invoice> invoices =invoiceRepository.getallinvoicebystatus();
    	 	
    	Map<Object, List<Invoice>> invoicesByCompany = invoices.stream()
    			.collect(Collectors.groupingBy(invoice -> invoice.getCompany().getCompanyid()));    	
    	
    	
	}
}


