package com.map.service;

import java.util.List;

import com.map.dto.ProductDto;
import com.map.dto.StatusDto;
import com.map.entity.Category;
import com.map.entity.Product;

public interface ProductService {

	public Object saveProductInformation(ProductDto product);

	public Object findbyid(int proid);

	public List<ProductDto> getallproduct();

	public String deleteproductbyid(int proid);

	public Object updateproductById(ProductDto productDto, int proid)throws Exception;

	public Object updateProductStatus(StatusDto statusDto, int id);

	public Object EnrollProductWithCategory(int  proid, int  categoryid);
	

}
