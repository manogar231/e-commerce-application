package com.map.service;

import java.util.List;

import com.map.dto.CategoryDto;
import com.map.entity.Category;
import com.map.entity.Product;

public interface CategoryService {

	public Object saveCategoryInformation(CategoryDto categorydto);

	public Object findcategorybyid(int categoryid);

	public String deletecategorybyid(int categoryid);

	public Object updatecategorybyid(CategoryDto categoryDto, int id) throws Exception;

	public List<CategoryDto> getallcategory(); 
	
	
	public void savecategoryproduct(Category category,Product product);
		
}
