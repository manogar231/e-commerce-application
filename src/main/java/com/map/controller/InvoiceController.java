package com.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.auth.ValidationAnnotation;
import com.map.dto.InvoiceDto;
import com.map.service.InvoiceService;
@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
		
   	@ValidationAnnotation
	  @PostMapping("/save")
	  public ResponseEntity<Object> saveInvoice(@RequestBody InvoiceDto invoiceDto) throws Exception {
		  return ResponseEntity.ok().body(invoiceService.saveinvoiceinformation(invoiceDto));
	  }
	  
	  
}
