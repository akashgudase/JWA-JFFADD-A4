package com.jspiders.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.entity.Product;
import com.jspiders.springboot.entity.Response;
import com.jspiders.springboot.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(value = "/product")
	protected ResponseEntity<Response<Product>> addProduct(@RequestBody Product product) {
		Product addedProduct = productService.addProduct(product);
		Response<Product> response = new Response<>();
		response.setMessage("Product added");
		response.setHttpStatusCode(HttpStatus.CREATED.value());
		response.setData(addedProduct);
		return new ResponseEntity<Response<Product>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/product")
	protected ResponseEntity<Response<Product>> deleteProduct(@RequestParam(name = "user_id") int userId,
			@RequestParam(name = "product_id") int productId) {
		Product deletedProduct = productService.deleteProduct(userId, productId);
		Response<Product> response = new Response<>();
		response.setMessage("Product deleted");
		response.setHttpStatusCode(HttpStatus.OK.value());
		response.setData(deletedProduct);
		return new ResponseEntity<Response<Product>>(response, HttpStatus.OK);
	}

}
