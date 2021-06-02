package br.com.marketplaceHotMart.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.marketplaceHotMart.dto.ProductDTO;
import br.com.marketplaceHotMart.model.Product;
import br.com.marketplaceHotMart.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	public ProductService productService;

	@GetMapping("/create")
	public String create(Model model, HttpServletRequest request) {
		model.addAttribute("product", new ProductDTO());
		return "create_product";
	}

	@PostMapping("/gravar")
	public String createAlterProduct(@ModelAttribute ProductDTO productDTO) {
		Product product = new Product(productDTO);
		productService.save(product);
		return "list_product";
	}

	@PostMapping("/listProduct")
	public String listAllProduct(Model model) {

		Iterable<Product> listAllProduct = productService.listAllProduct();

		List<Product> productions = StreamSupport.stream(listAllProduct.spliterator(), false)
				.collect(Collectors.toList());

		model.addAllAttributes(productions);
		return "list_product";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@ModelAttribute ProductDTO productDTO, Model model) {
		Product product = new Product(productDTO);
		productService.delete(product);
		return "list_product";
	}
	@PostMapping("/findProduct/{id}")
	public String findProduct(@ModelAttribute Integer identifier, Model model) { 
		return "find_product"; 
	}
}
