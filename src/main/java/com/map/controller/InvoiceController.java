package com.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.map.dto.InvoiceDto;
import com.map.service.InvoiceService;
@Controller
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
		
	@Autowired
	private RestTemplate restTemplate;
	
	final String baseurl="http://localhost:8081/";
	
	  @GetMapping("/product")
	    public Object getproductbyid() {
	        String url = baseurl + "product/allproduct";
	        Object result = restTemplate.getForObject(url, Object.class);
	        return "This Response from Application 2 "  +result;		 				  
	  }	  
	  @GetMapping("invoice.pdf")
	  public Object invoicegenerate() {
		  String url=baseurl+"/invoice/save";
		  Object result=restTemplate.getForObject(url, Object.class);
		  return result;
	  }
	  @PostMapping("/save")
	  public Object saveInvoice(@RequestBody InvoiceDto invoiceDto) {
		  return invoiceService.saveinvoiceinformation(invoiceDto);
	  }
	  
	  
}
