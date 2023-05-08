package com.map.serviceimpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.dto.CompanyDto;
import com.map.entity.Company;
import com.map.exception.GlobalExceptionHandler;
import com.map.repository.CompanyRepository;
import com.map.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Object savecompanyinformation(CompanyDto companyDto) {
		Company company = new Company();
		company.setCompanyname(companyDto.getCompanyname());
		company.setCompanyaddress(companyDto.getCompanyaddress());
		companyRepository.save(company);
		return "Company Saved Successfully";
	}

	public CompanyDto findcompanyById(Integer id) {
		Optional<Company> company = companyRepository.findcompanybyid(id);
		if (company.isEmpty()) {
			System.out.println("Company Not Found!!");
		}
		
		return modelMapper.map(company.get(), CompanyDto.class);
	}

	public List<CompanyDto> listofcompany() {
		List<Company> company = companyRepository.findAll();
		return company.stream().map(Company -> modelMapper.map(Company, CompanyDto.class)).collect(Collectors.toList());
	}

	public String deletecompany(Integer id) {
		Optional<Company> company = companyRepository.findById(id);
		if (company.isEmpty()) {
			return "Company Not Found !!";
		}
		companyRepository.deleteById(id);
		return "Company Deleted Successfuly!!!";
	}

	public String updatecompany(Integer id, CompanyDto companyDto) throws GlobalExceptionHandler {
		Company company = companyRepository.findById(id).orElseThrow(() -> new GlobalExceptionHandler());
		if (Objects.nonNull(companyDto.getCompanyname())) {
			company.setCompanyname(companyDto.getCompanyname());
		}
		if (Objects.nonNull(companyDto.getCompanyaddress())) {
			company.setCompanyaddress(companyDto.getCompanyaddress());
		}
		companyRepository.save(company);
		return "Company Updated Successfully !!";
	}

}
