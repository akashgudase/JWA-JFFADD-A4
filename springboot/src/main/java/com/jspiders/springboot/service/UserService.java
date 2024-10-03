package com.jspiders.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.entity.Product;
import com.jspiders.springboot.entity.User;
import com.jspiders.springboot.repository.ProductRepository;
import com.jspiders.springboot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public User findUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	public User findUserByEmailAndPassword(String email, String password) {
		return userRepository.findUserByEmailAndPassword(email, password);
	}

	public User deleteUser(int id) {
		User user = userRepository.findById(id).get();
		userRepository.deleteById(id);
		return user;
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User findUserByMobileAndPassword(long mobile, String password) {
		return userRepository.findUserByMobileAndPassword(mobile, password);
	}

	public User mapProductToUser(int userId, int productId) {
		User user = userRepository.findById(userId).get();
		Product product = productRepository.findById(productId).get();
		List<Product> products = user.getProducts();
		products.add(product);
		user.setProducts(products);
		return userRepository.save(user);
	}

}
