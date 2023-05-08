package com.map.service;

import java.util.List;

import com.map.dto.CompanyDto;
import com.map.exception.GlobalExceptionHandler;

public interface CompanyService {

	Object savecompanyinformation(CompanyDto companyDto);

	Object findcompanyById(Integer id);

	String deletecompany(Integer id);

	List<CompanyDto> listofcompany();

	String updatecompany(Integer id, CompanyDto companyDto)throws GlobalExceptionHandler;

}
