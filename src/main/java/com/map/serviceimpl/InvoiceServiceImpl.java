package com.map.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.map.dto.InvoiceDto;
import com.map.dto.ProductDto;
import com.map.entity.Company;
import com.map.entity.Invoice;
import com.map.entity.User;
import com.map.handler.GlobalExceptionHandler;
import com.map.repository.CompanyRepository;
import com.map.repository.InvoiceRepository;
import com.map.repository.UserRepository;
import com.map.service.InvoiceService;
import com.map.util.InvoiceStatus;


@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
    private CompanyRepository companyRepository;
	@Autowired
	private  UserRepository userRepository ;  
	   
	public Object saveinvoiceinformation(InvoiceDto invoiceDto) throws Exception {
		
		int totalamount=0;
		Invoice invoice=new Invoice();
		Optional<Company> companyoptional=companyRepository.findById(invoiceDto.getCompanyid());	
		if (companyoptional.isEmpty()) {
			throw new  GlobalExceptionHandler();	
		}
	   Optional<User> userOptional=userRepository.findByUsername(invoiceDto.getUsername());
	   if(userOptional.isEmpty()) {
		   throw new GlobalExceptionHandler();  
	   }
	   //change the list of product to string and save it in the database	
		ObjectMapper objectMapper = new ObjectMapper();
		List<ProductDto> productList = invoiceDto.getProduct();
		String productJson = objectMapper.writeValueAsString(productList);	
		invoice.setProductJson(productJson);
        invoice.setInvoicenumber(UUID.randomUUID().toString());
		for (ProductDto product : invoiceDto.getProduct()) {			
		int price=product.getPrice();
		totalamount=totalamount+price;
		}
		Optional<Company> optionalCompany = companyRepository.findById(invoiceDto.getCompanyid());
		Company company = optionalCompany.orElse(null);
		invoice.setCompany(company);
	    Optional<User>optionaluser=userRepository.findByUsername(invoiceDto.getUsername());
		User user=optionaluser.orElse(null);
		invoice.setUser(user);
		invoice.setTotal(totalamount);
		invoice.setStatus(InvoiceStatus.NOTPAID);
	    return invoiceRepository.save(invoice);
	}
}
