package br.com.marketplaceHotMart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.marketplaceHotMart.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
}
