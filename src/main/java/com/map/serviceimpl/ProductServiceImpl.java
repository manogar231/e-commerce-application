package com.map.serviceimpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.dto.ProductDto;
import com.map.dto.StatusDto;
import com.map.entity.Category;
import com.map.entity.Product;
import com.map.repository.CategoryRepository;
import com.map.repository.ProductRepository;
import com.map.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper modelMapper;

	public Object saveProductInformation(ProductDto product) {

		Product products = new Product();
		products.setProname(product.getProname());
		products.setPrice(product.getPrice());
		return productRepository.save(products);
	}

	public Object findbyid(int proid) {
		Optional<Product> product = productRepository.findById(proid);
		return product;
	}

	public List<ProductDto> getallproduct() {
		List<Product> product = productRepository.findAll();
		return product.stream().map(Product -> modelMapper.map(Product, ProductDto.class)).collect(Collectors.toList());
	}

	public String deleteproductbyid(int proid) {

		productRepository.deleteById(proid);
		return "Product deleted successfully";
	}

	public Object updateproductById(ProductDto productDto, int proid) throws Exception {

		Product updateproduct = productRepository.findById(proid).orElseThrow(() -> new Exception("Product not found"));
		if (Objects.nonNull(productDto.getProname())) {

			updateproduct.setProname(productDto.getProname());
		}
		if (Objects.nonNull(productDto.getPrice())) {
			updateproduct.setPrice(productDto.getPrice());
		}

		return productRepository.save(updateproduct);
	}

	public Object updateProductStatus(StatusDto statusDto, int id) {

		return productRepository.updateproductStatus(statusDto.getStatus(), id);
	}

	public Object EnrollProductWithCategory(int  proid, int  categoryid) {
		    
        Product product =productRepository.findById(proid).get();    
		Category category=categoryRepository.findById(categoryid).get();
		product.setCategory(category);
		return productRepository.save(product);
	}

}
