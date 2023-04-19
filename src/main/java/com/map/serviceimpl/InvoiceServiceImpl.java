package com.map.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.map.dto.InvoiceDto;
import com.map.dto.ProductDto;
import com.map.entity.Invoice;
import com.map.repository.InvoiceRepository;
import com.map.service.InvoiceService;


@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	
	public Object saveinvoiceinformation(InvoiceDto invoiceDto) {
  
		Invoice invoice=new Invoice();
		
      //  invoice.setCompany(invoiceDto.getCompanyname());	
		
		
		int invoice2= invoice.getInvoiceid();
        
        for (ProductDto product : invoiceDto.getProduct()) {
        	           
        }
       
       
       invoice.setInvoicenumber(UUID.randomUUID().toString());
		
		return null;
	}
	
	
	
}
