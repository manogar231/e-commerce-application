package com.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.auth.ValidationAnnotation;
import com.map.dto.CategoryDto;
import com.map.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    
	@Autowired
	private CategoryService categoryService;
	
	@ValidationAnnotation
	@PostMapping("/save")
	public ResponseEntity<Object> saveCategory(@RequestBody CategoryDto categorydto) {
		return ResponseEntity.ok().body(categoryService.saveCategoryInformation(categorydto));
	}
	@ValidationAnnotation
	@GetMapping("/{id}")
	public Object findcategorybyid(@PathVariable int id) {
		return categoryService.findcategorybyid(id);
	}
	@ValidationAnnotation
	@GetMapping("/allcategory")
	public List<CategoryDto>getallcategory(){
		return categoryService.getallcategory();
	}
	@ValidationAnnotation
	@PutMapping("/update/{id}")
	public Object updatecategory(@PathVariable int id ,@RequestBody CategoryDto categoryDto)throws Exception {
		return categoryService.updatecategorybyid(categoryDto, id);
	}
	@ValidationAnnotation
     @DeleteMapping("/delete/{id}")
	public Object deletecategorybyid(@PathVariable int id) {
		return categoryService.deletecategorybyid(id);
	}
     
     
}
