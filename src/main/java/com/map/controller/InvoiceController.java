package com.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.map.dto.InvoiceDto;
import com.map.service.InvoiceService;
@Controller

public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
		
	  @PostMapping("invoice/save")
	  public ResponseEntity<Object> saveInvoice(@RequestBody InvoiceDto invoiceDto) throws Exception {
		  return ResponseEntity.ok().body(invoiceService.saveinvoiceinformation(invoiceDto));
	  }
	  
	  
}
