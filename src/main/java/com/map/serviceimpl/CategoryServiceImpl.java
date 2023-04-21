package com.map.serviceimpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.dto.CategoryDto;
import com.map.entity.Category;
import com.map.entity.Product;
import com.map.repository.CategoryRepository;
import com.map.repository.ProductRepository;
import com.map.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Object saveCategoryInformation(CategoryDto categorydto) {
		Category categorys = new Category();
		categorys.setCategoryname(categorydto.getCategoryname());
		return categoryRepository.save(categorys);
	}

	public Object findcategorybyid(int categoryid) {

		Optional<Category> category = categoryRepository.findById(categoryid);

		if (category.isEmpty()) {
			return "Category Is Not Found !!";
		}
    	return	modelMapper.map(category.get(), CategoryDto.class);		
	}

	public List<CategoryDto> getallcategory() {

		List<Category> category = categoryRepository.findAll();
		return category.stream().map(Category -> modelMapper.map(Category, CategoryDto.class))
				.collect(Collectors.toList());
	}

	public String deletecategorybyid(int categoryid) {

		Optional<Category> category = categoryRepository.findById(categoryid);
		if (category.isEmpty()) {
			return "Category Not Found !!";
		}
		categoryRepository.deleteById(categoryid);
		return "category deleted successfully";
	}

	public Object updatecategorybyid(CategoryDto categoryDto, int id) throws Exception {
		Category updatecategory = categoryRepository.findById(id)
				.orElseThrow(() -> new Exception("Category Not Found"));
		if (Objects.nonNull(categoryDto.getCategoryname())) {
			updatecategory.setCategoryname(categoryDto.getCategoryname());

		}
		return categoryRepository.save(updatecategory);
	}

	@Transactional
	public void savecategoryproduct(Category category, Product product) {

		categoryRepository.save(category);
		// product.setCategory(category);
		productRepository.save(product);

	}

}
