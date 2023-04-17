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

import com.map.dto.ProductDto;
import com.map.dto.StatusDto;
import com.map.entity.Category;
import com.map.entity.Product;
import com.map.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/save")
	public ResponseEntity<Object> saveProduct(@RequestBody ProductDto productdto) {
		return ResponseEntity.ok().body(productService.saveProductInformation(productdto));
	}

	@GetMapping("/{id}")
	public Object findbyid(@PathVariable Integer proid) {
		return productService.findbyid(proid);
	}

	@GetMapping("/allproduct")
	public List<ProductDto> getallproduct() {
		return productService.getallproduct();
	}

	@DeleteMapping("/delete/{id}")
	public Object deleteproduct(@PathVariable Integer proid) {

		return productService.deleteproductbyid(proid);
	}

	@PutMapping("/update/{id}")
	public Object updateproduct(@PathVariable int id, @RequestBody ProductDto productDto) throws Exception {

		return productService.updateproductById(productDto, id);
	}
     @PutMapping("/status/{id}")
	public Object updateProductStatus( @RequestBody StatusDto statusDto,@PathVariable int id) {
		return productService.updateProductStatus(statusDto, id);

	}
    @PutMapping("/{productid}/category/{id}")
    public Object EnrollProductWithCategory(@PathVariable int  proid,@PathVariable int  categoryid) {
    	return productService.EnrollProductWithCategory(proid , categoryid);
    }
}
