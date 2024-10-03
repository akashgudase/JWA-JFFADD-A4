package com.jspiders.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.entity.Product;
import com.jspiders.springboot.entity.User;
import com.jspiders.springboot.repository.ProductRepository;
import com.jspiders.springboot.repository.UserRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Product deleteProduct(int userId, int productId) {
		User user = userRepository.findById(userId).get();
		Product product = productRepository.findById(productId).get();
		List<Product> products = user.getProducts();
		products.remove(product);
		user.setProducts(products);
		userRepository.save(user);
		productRepository.delete(product);
		return product;
	}

}
