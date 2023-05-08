package com.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.auth.ValidationAnnotation;
import com.map.dto.CompanyDto;
import com.map.exception.GlobalExceptionHandler;
import com.map.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
     
	@Autowired
	private CompanyService companyService;
	
	@ValidationAnnotation
	@PostMapping("/save")
	public Object SaveCompanyInformation(@RequestBody CompanyDto companyDto) {
		
		return companyService.savecompanyinformation(companyDto); 
	}
	@ValidationAnnotation
	@GetMapping("/{id}")
	public Object finduserbyid(@PathVariable Integer id ) throws Exception {
		return companyService.findcompanyById(id);
	}
	@ValidationAnnotation
	@GetMapping("/All")
	public List<CompanyDto> listofObjectcompany() {
		return companyService.listofcompany();
	}
	@ValidationAnnotation
	@DeleteMapping("/delete/{id}")
	public String deletecompany(@PathVariable Integer id) {
		return companyService.deletecompany(id);
	}
	@ValidationAnnotation
	@PutMapping("/update/{id}")
	public String updatecompany(@PathVariable Integer id ,@RequestBody CompanyDto companyDto)throws GlobalExceptionHandler {
		return companyService.updatecompany(id , companyDto);
	}
	
	
	
	
	
	
}
