package br.com.marketplaceHotMart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.marketplaceHotMart.model.Product;
import br.com.marketplaceHotMart.repository.ProductRepository;

public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public void delete(Product product) {
		productRepository.delete(product);
	}

	public Optional<Product> listProduct(Product product) {
		return productRepository.findById(product.getIdentifier());
	}

	public Iterable<Product> listAllProduct() {
		return productRepository.findAll();
	}
}
